package com.yunhuakeji.app.ui.activity;

import android.Manifest;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.yunhuakeji.app.R;
import com.yunhuakeji.app.application.YunHuaApplication;
import com.yunhuakeji.app.authority.AuthorityManagement;
import com.yunhuakeji.app.authority.PermissionsActivity;
import com.yunhuakeji.app.constants.Constants;
import com.yunhuakeji.app.constants.YunHuaUrl;
import com.yunhuakeji.app.http.OkHttpRequest;
import com.yunhuakeji.app.http.VolleyInterface;
import com.yunhuakeji.app.http.VolleyRequest;
import com.yunhuakeji.app.model.StudentInfoModel;
import com.yunhuakeji.app.util.FileStorage;
import com.yunhuakeji.app.util.UploadUtil;
import com.yunhuakeji.app.view.MyActivity;
import com.yunhuakeji.app.view.RoundImageView;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserInfoActivity extends MyActivity implements View.OnClickListener {

    @BindView(R.id.ly_persona_title)
    RelativeLayout lyPersonaTitle;
    @BindView(R.id.rl_userinfo_handimg)
    RelativeLayout rlUserinfoHandimg;
    @BindView(R.id.rl_userinfo_nickname)
    RelativeLayout rlUserinfoNickname;
    @BindView(R.id.rl_userinfo_phone)
    RelativeLayout rlUserinfoPhone;
    @BindView(R.id.rl_userinfo_qq)
    RelativeLayout rlUserinfoQq;
    @BindView(R.id.rl_userinfo_erweima)
    RelativeLayout rlUserinfoErweima;
    @BindView(R.id.btn_persona_out)
    Button btnPersonaOut;
    @BindView(R.id.txt_userinfo_nickname)
    TextView txtUserinfoNickname;
    @BindView(R.id.txt_userinfo_section)
    TextView txtUserinfoSection;
    @BindView(R.id.txt_userinfo_major)
    TextView txtUserinfoMajor;
    @BindView(R.id.txt_userinfo_phone)
    TextView txtUserinfoPhone;
    @BindView(R.id.txt_userinfo_qq)
    TextView txtUserinfoQq;
    @BindView(R.id.txt_userinfo_birthday)
    TextView txtUserinfoBirthday;
    @BindView(R.id.img_userinfo_userphoto)
    RoundImageView imgUserinfoUserphoto;
    @BindView(R.id.textView)
    TextView textView;


    private LinearLayout lyPopwindButton;
    private Button btnPopwindhandimPhotograph;
    private Button btnPopwindhandimAlbum;
    private Button btnPopwindhandimCancel;
    private RelativeLayout rlPopwindhandimOut;

    private PopupWindow handphotowindow;

    private StudentInfoModel studentInfoModel;
    private String nickename = null, phonenumber = null, qq = null;


    /**
     * 记录是修改的那个模块
     * 用于接收返回值
     */
    //昵称
    private final int RESULT_NICKNAME = 0;
    //电话号码
    private final int RESULT_PHONENUMBER = 1;
    //QQ
    private final int RESULT_QQ = 2;
    //相册
    private final int PHOTO_REQUEST = 3;
    //相机
    private final int CAMERA_REQUEST = 4;
    //裁剪图片
    private final int PHOTO_CLIP = 5;
    //权限申请
    private final int REQUEST_PERMISSION = 6;
    //相机权限
    static final String[] PERMISSIONS = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA};

    //标识是那个地方传过去的
    private final int USERINFO_CODE = 100;
    //原图片地址
    private Uri imageUri;
    //图片路径
    private String imagePath;

    //用于判断是相册还是相机图片来源
    private boolean isClickCamera;
    private AuthorityManagement authorityManagement;

    @Override
    protected void initActivity() {
        setContentView(R.layout.activity_user_info);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        rlUserinfoHandimg.setOnClickListener(this);
        rlUserinfoNickname.setOnClickListener(this);
        rlUserinfoErweima.setOnClickListener(this);
        rlUserinfoPhone.setOnClickListener(this);
        rlUserinfoQq.setOnClickListener(this);
        authorityManagement = new AuthorityManagement(this);
    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("userid", "11204050220");
        map.put("ticket", Constants.ticket);
        VolleyRequest.RequestPost(YunHuaUrl.USERINFO_URL_GETSTUDENTINFO, "userinfo", map, new VolleyInterface(VolleyInterface.mListener, VolleyInterface.mErrorListener) {
            @Override
            public void onMySuccess(String result) {
                //成功
                if (!result.isEmpty()) {
                    studentInfoModel = YunHuaApplication.getInstance().getGson().fromJson(result, StudentInfoModel.class);
                    bindData(studentInfoModel.getContent().getMessage());
                    Log.e("用户消息", result);
                }

            }

            @Override
            public void onMyError(VolleyError error) {
                //失败
                Toast.makeText(getContext(), R.string.str_tool_neterror, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void initProcessor() {


    }

    private void showUpdateHandPhoto(View view) {
        View window = LayoutInflater.from(this).inflate(R.layout.popwind_update_handimg, null, false);

        //设置窗体大小
        handphotowindow = new PopupWindow(window, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

        handphotowindow.setFocusable(true);
        handphotowindow.setOutsideTouchable(false);
        handphotowindow.setAnimationStyle(android.R.style.Animation_InputMethod);
        handphotowindow.showAtLocation(view, Gravity.CENTER, 0, 0);


        lyPopwindButton = (LinearLayout) window.findViewById(R.id.ly_popwind_button);
        lyPopwindButton.setOnClickListener(this);
        btnPopwindhandimPhotograph = (Button) window.findViewById(R.id.btn_popwindhandim_photograph);
        btnPopwindhandimPhotograph.setOnClickListener(this);
        btnPopwindhandimAlbum = (Button) window.findViewById(R.id.btn_popwindhandim_album);
        btnPopwindhandimAlbum.setOnClickListener(this);
        btnPopwindhandimCancel = (Button) window.findViewById(R.id.btn_popwindhandim_cancel);
        btnPopwindhandimCancel.setOnClickListener(this);
        rlPopwindhandimOut = (RelativeLayout) window.findViewById(R.id.rl_popwindhandim_out);
        rlPopwindhandimOut.setOnClickListener(this);


    }

    /***
     * 手机拍照
     */
    private void getPicFromCamera() {

        File file = new FileStorage().createCropFile();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            imageUri = FileProvider.getUriForFile(this, "com.yunhuakeji.app.fileprovider", file);//通过FileProvider创建一个content类型的Uri
        } else {
            imageUri = Uri.fromFile(file);
        }
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); //添加这一句表示对目标应用临时授权该Uri所代表的文件
        }
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);//设置Action为拍照
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);//将拍取的照片保存到指定URI
        startActivityForResult(intent, CAMERA_REQUEST);
    }

    /***
     * 相册选择
     */
    private void getPicFromPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*");
        startActivityForResult(intent, PHOTO_REQUEST);
    }

    /****
     * 调用系统自带切图工具
     *
     */
    private void photoClip() {
        // 调用系统中自带的图片剪裁
        File file = new FileStorage().createCropFile();
        Uri outputUri = Uri.fromFile(file);
        Intent intent = new Intent("com.android.camera.action.CROP");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        }
        intent.setDataAndType(imageUri, "image/*");
        intent.putExtra("crop", "true");//发送裁剪信号
        intent.putExtra("aspectX", 1);//x方向的比例
        intent.putExtra("aspectY", 1);//Y方向的比例
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("scale", true);//是否保存裁剪比例
        intent.putExtra("return-data", true);//是否将数据保存在bitmap中返回
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri);//裁剪的图片保存地址
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());//图片输入格式
        intent.putExtra("noFaceDetection", true);//是否取消人脸识别
        startActivityForResult(intent, PHOTO_CLIP);
    }

    /**
     * 转成图片地址
     *
     * @param uri
     * @param selection
     * @return
     */
    private String getImagePath(Uri uri, String selection) {
        String path = null;
        //通过Uri和selection老获取真实的图片路径
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }


    /**
     * 4.4以上调用
     *
     * @param data
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void handleImageOnKitKat(Intent data) {
        imagePath = null;
        imageUri = data.getData();
        if (DocumentsContract.isDocumentUri(this, imageUri)) {
            //如果是document类型的uri,则通过document id处理
            String docId = DocumentsContract.getDocumentId(imageUri);
            if ("com.android.providers.media.documents".equals(imageUri.getAuthority())) {
                String id = docId.split(":")[1];//解析出数字格式的id
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.downloads.documents".equals(imageUri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
                imagePath = getImagePath(contentUri, null);
            }
        } else if ("content".equalsIgnoreCase(imageUri.getScheme())) {
            //如果是content类型的Uri，则使用普通方式处理
            imagePath = getImagePath(imageUri, null);
        } else if ("file".equalsIgnoreCase(imageUri.getScheme())) {
            //如果是file类型的Uri,直接获取图片路径即可
            imagePath = imageUri.getPath();
        }
        photoClip();
    }

    /**
     * 4.4 以下处理
     *
     * @param intent
     */
    private void handleImageBeforeKitKat(Intent intent) {
        imageUri = intent.getData();
        imagePath = getImagePath(imageUri, null);
        photoClip();
    }


    /**
     * 绑定数据
     * 给控件赋值
     */
    private void bindData(StudentInfoModel.ContentBean.MessageBean messageBean) {
        Glide.with(getContext()).load(messageBean.getFaceaddress()).error(R.mipmap.ico_userhand).placeholder(R.mipmap.ico_load_little).into(imgUserinfoUserphoto);//用户头像
        txtUserinfoNickname.setText(messageBean.getNc());//昵称
        txtUserinfoBirthday.setText(messageBean.getSr());//生日
        txtUserinfoSection.setText(messageBean.getXy());//学校部门
        txtUserinfoMajor.setText(messageBean.getZymc());//专业
        txtUserinfoPhone.setText(messageBean.getLxdh());//电话
        txtUserinfoQq.setText(messageBean.getQq());//qq


    }

    //退出当前
    public void back(View view) {
        finish();
    }

    //获取权限
    private void startPermissionsActivity() {
        PermissionsActivity.startActivityForResult(this, REQUEST_PERMISSION,
                PERMISSIONS);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ly_persona_title:
                break;
            case R.id.rl_userinfo_handimg:
                showUpdateHandPhoto(rlUserinfoHandimg);
                break;
            case R.id.rl_userinfo_nickname:
                //修改昵称
                nickename = txtUserinfoNickname.getText().toString();
                Intent updatenickeintent = new Intent(this, UpdateNickNameActivity.class);
                updatenickeintent.putExtra("nickename", nickename);
                startActivityForResult(updatenickeintent, USERINFO_CODE);
                break;
            case R.id.rl_userinfo_phone:
                //修改电话号码
                phonenumber = txtUserinfoPhone.getText().toString();
                Intent updatephoneintent = new Intent(this, UpdatePhoneActivity.class);
                updatephoneintent.putExtra("phonenumber", phonenumber);
                startActivityForResult(updatephoneintent, USERINFO_CODE);

                break;
            case R.id.rl_userinfo_qq:
                //修改QQ号
                qq = txtUserinfoQq.getText().toString();
                Intent updateqqinintent = new Intent(this, UpdateQQActivity.class);
                updateqqinintent.putExtra("qq", qq);
                startActivityForResult(updateqqinintent, USERINFO_CODE);
                break;
            case R.id.rl_userinfo_erweima:
                //跳转到二维码页面
                Intent erweimaintent = new Intent(this, ErWeiMaUserinfoActivity.class);
                startActivity(erweimaintent);
                break;
            case R.id.btn_persona_out:
                //退出登陆
                break;

            case R.id.rl_popwindhandim_out:
                if (handphotowindow.isShowing()) {
                    handphotowindow.dismiss();
                }

                break;
            case R.id.btn_popwindhandim_photograph:
                //相机
                //检查权限(6.0以上做权限判断)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    startPermissionsActivity();
                } else {
                    getPicFromCamera();
                }
                isClickCamera = true;
                break;
            case R.id.btn_popwindhandim_album:
                //相册
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (authorityManagement.lacksPermissions(PERMISSIONS)) {
                        startPermissionsActivity();
                    } else {
                        getPicFromPhoto();
                    }
                } else {
                    getPicFromPhoto();
                }
                isClickCamera = false;

                break;
            case R.id.btn_popwindhandim_cancel:
                //取消
                if (handphotowindow.isShowing()) {
                    handphotowindow.dismiss();
                }

                break;
        }
    }

    /**
     * 得到返回值
     *
     * @param requestCode 标识从哪里跳转过去的
     * @param resultCode  第二个页面穿过来的
     * @param data        第二个页面传过来的值
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == USERINFO_CODE) {
            switch (resultCode) {
                case RESULT_NICKNAME:
                    if (null != data) {
                        String nickename = data.getStringExtra("nickename");
                        txtUserinfoNickname.setText(nickename);
                    }

                    break;
                case RESULT_PHONENUMBER:
                    if (null != data) {
                        String phonenumber = data.getStringExtra("phonenumber");
                        txtUserinfoPhone.setText(phonenumber);
                    }

                    break;
                case RESULT_QQ:
                    if (null != data) {
                        String qq = data.getStringExtra("qq");
                        txtUserinfoQq.setText(qq);
                    }
                    break;
            }
        } else {
            switch (requestCode) {
                case CAMERA_REQUEST:
                    if (resultCode == RESULT_OK) {
                        //拍照成功 裁剪
                        photoClip();
                    }
                    break;
                case PHOTO_REQUEST:
                    //从相册取照片
                    if (null != data) {
                        if (Build.VERSION.SDK_INT >= 19) {
                            handleImageOnKitKat(data);
                        } else {
                            handleImageBeforeKitKat(data);
                        }
                    }

                    break;
                case PHOTO_CLIP:
                    //裁剪图片
                    Bitmap bitmap = null;
                    try {
                        if (isClickCamera) {

                            bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        } else {
                            bitmap = BitmapFactory.decodeFile(imagePath);
                        }
                        imgUserinfoUserphoto.setImageBitmap(bitmap);
                        if (handphotowindow.isShowing()) {
                            handphotowindow.dismiss();
                        }
                        //将bitmap 转化成文件
                        File file = UploadUtil.saveFile(bitmap, Environment.getExternalStorageDirectory().toString(), "hand.jpg");
                        //上传文件
                        OkHttpRequest.postAsynFile(file, YunHuaUrl.USERINFO_URL_UPDATEHANDPHOTO);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case REQUEST_PERMISSION:
                    if (resultCode == PermissionsActivity.PERMISSIONS_DENIED) {
                        finish();
                    } else {
                        if (isClickCamera) {
                            getPicFromCamera();
                        } else {
                            getPicFromPhoto();
                        }
                    }
                    break;
            }
        }

        super.onActivityResult(requestCode, resultCode, data);

    }

}
