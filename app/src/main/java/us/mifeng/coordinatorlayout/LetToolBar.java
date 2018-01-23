package us.mifeng.coordinatorlayout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 黑夜之火 on 2018/1/22.
 */

public class LetToolBar extends Toolbar{
    //添加视图工具
    private LayoutInflater inflater;
    //添加视图
    private View mView;
    private LayoutInflater mInflater;
    private EditText mEditSearchView;
    private TextView mTextTitle;
    private ImageView mLeftButton;
    private ImageView mRightButton;


    public LetToolBar(Context context) {
        this(context,null);
    }

    public LetToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs,-1);
    }

    public LetToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();

        //Set the content insets for this toolbar relative to layout direction.
        setContentInsetsRelative(10, 10);

        if (attrs != null) {
            //读写自定义的属性，如果不会自己写的时候

            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                    R.styleable.LetToolBar, defStyleAttr, 0);

            final Drawable leftIcon = a.getDrawable(R.styleable.LetToolBar_leftButtonIcon);
            if (leftIcon != null) {
                setLeftButtonIcon(leftIcon);
            }

            final Drawable rightIcon = a.getDrawable(R.styleable.LetToolBar_rightButtonIcon);
            if (rightIcon != null) {
                setRightButtonIcon(rightIcon);
            }


            boolean isShowSearchView = a.getBoolean(R.styleable.LetToolBar_isShowSearchView, false);

            //如果要显示searchView的时候
            if (isShowSearchView) {
                showSearchView();
                hideTitleView();
            }
            //资源的回收
            a.recycle();
        }
    }

    private void initView() {
        if (mView == null) {
            //初始化
            mInflater = LayoutInflater.from(getContext());
            //添加布局文件
            mView = mInflater.inflate(R.layout.toolbar_item, null);

            //绑定控件
            mEditSearchView = (EditText) mView.findViewById(R.id.searchView);
            mTextTitle = (TextView) mView.findViewById(R.id.toolTitle);
            mLeftButton = (ImageButton) mView.findViewById(R.id.leftIcon);
            mRightButton = (ImageButton) mView.findViewById(R.id.rightIcon);
            //然后使用LayoutParams把控件添加到子view中
            LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
            addView(mView, lp);

        }
    }
    @Override
    public void setTitle(int resId) {
        setTitle(getContext().getText(resId));
    }

    @Override
    public void setTitle(CharSequence title) {
        initView();
        if (mTextTitle != null) {
            mTextTitle.setText(title);
            showTitleView();
        }
    }

    //隐藏标题
    public void hideTitleView() {
        if (mTextTitle != null)
            mTextTitle.setVisibility(GONE);
    }

    //显示标题
    public void showTitleView() {
        if (mTextTitle != null)
            mTextTitle.setVisibility(VISIBLE);
    }

    //显示搜索框
    public void showSearchView() {
        if (mEditSearchView != null)
            mEditSearchView.setVisibility(VISIBLE);
    }

    //隐藏搜索框
    public void hideSearchView() {
        if (mEditSearchView != null) {
            mEditSearchView.setVisibility(GONE);
        }
    }

    //给右侧按钮设置图片，也可以在布局文件中直接引入
    // 如：app:leftButtonIcon="@drawable/icon_back_32px"
    public void setRightButtonIcon(Drawable icon) {
        if (mRightButton != null) {
            mRightButton.setImageDrawable(icon);
            mRightButton.setVisibility(VISIBLE);
        }
    }

    //给左侧按钮设置图片，也可以在布局文件中直接引入
    private void setLeftButtonIcon(Drawable icon) {
        if (mLeftButton != null){
            mLeftButton.setImageDrawable(icon);
            mLeftButton.setVisibility(VISIBLE);
        }
    }

    //设置右侧按钮监听事件
    public void setRightButtonOnClickLinster(OnClickListener linster) {
        mRightButton.setOnClickListener(linster);
    }

    //设置左侧按钮监听事件
    public void setLeftButtonOnClickLinster(OnClickListener linster) {
        mLeftButton.setOnClickListener(linster);
    }
}
