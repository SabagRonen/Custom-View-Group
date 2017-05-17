package com.example.ronensabag.customviewgroup;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class CustomViewGroup extends FrameLayout {

    private View mAvatar;
    private View mName;
    private View mNumberOfRiders;
    private View mMore;
    private int mAvatarRightMargin;
    private int mAvatarLeftMargin;
    private int mAvatarTopMargin;
    private int mNumberOfRidersLeftMargin;
    private int mMoreRightMargin;
    private int mMoreLeftMargin;
    private int mMoreTopMargin;

    public CustomViewGroup(Context context) {
        super(context);
        init(context);
    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.custom_view_group, this);

        mAvatar = findViewById(R.id.avatar);
        MarginLayoutParams avatarLayoutParams = (MarginLayoutParams) mAvatar.getLayoutParams();
        mAvatarRightMargin = avatarLayoutParams.rightMargin;
        mAvatarLeftMargin = avatarLayoutParams.leftMargin;
        mAvatarTopMargin = avatarLayoutParams.topMargin;

        mName = findViewById(R.id.name);

        mNumberOfRiders = findViewById(R.id.number_of_riders);
        MarginLayoutParams numberOfRidersLayoutParams = (MarginLayoutParams) mNumberOfRiders.getLayoutParams();
        mNumberOfRidersLeftMargin = numberOfRidersLayoutParams.leftMargin;

        mMore = findViewById(R.id.more);
        MarginLayoutParams moreLayoutParams = (MarginLayoutParams) mAvatar.getLayoutParams();
        mMoreRightMargin = moreLayoutParams.rightMargin;
        mMoreLeftMargin = moreLayoutParams.leftMargin;
        mMoreTopMargin = moreLayoutParams.topMargin;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthUsed = 0;
        int heightUsed = 0;

        measureChildWithMargins(mAvatar, widthMeasureSpec, 0, heightMeasureSpec, heightUsed);
        widthUsed += mAvatar.getMeasuredWidth() + mAvatarLeftMargin + mAvatarRightMargin;

        measureChildWithMargins(mNumberOfRiders, widthMeasureSpec, 0, heightMeasureSpec,
                heightUsed);
        widthUsed += mNumberOfRiders.getMeasuredWidth() + mNumberOfRidersLeftMargin;

        measureChildWithMargins(mMore, widthMeasureSpec, 0, heightMeasureSpec, heightUsed);
        widthUsed += mMore.getMeasuredWidth() + mMoreLeftMargin + mMoreRightMargin;

        measureChildWithMargins(mName, widthMeasureSpec, widthUsed, heightMeasureSpec, heightUsed);
        widthUsed += mName.getMeasuredWidth();

        setMeasuredDimension(
                resolveSize(widthUsed, widthMeasureSpec),
                resolveSize(MeasureSpec.getSize(heightMeasureSpec), heightMeasureSpec));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left = l + mAvatarLeftMargin;
        int top = mAvatarTopMargin;

        mAvatar.layout(left, top, left + mAvatar.getMeasuredWidth(),
                top + mAvatar.getMeasuredHeight());
        left += mAvatar.getMeasuredWidth() + mAvatarRightMargin;

        top = (getMeasuredHeight() - mName.getMeasuredHeight()) / 2;
        mName.layout(left, top, left + mName.getMeasuredWidth(), top + mName.getMeasuredHeight());
        left += mName.getMeasuredWidth();

        left += mNumberOfRidersLeftMargin;
        top = (getMeasuredHeight() - mNumberOfRiders.getMeasuredHeight()) / 2;
        mNumberOfRiders.layout(left, top, left + mNumberOfRiders.getMeasuredWidth(),
                top + mNumberOfRiders.getMeasuredHeight());

        left = r - mMoreRightMargin - mMore.getMeasuredWidth();
        top = mMoreTopMargin;
        mMore.layout(left, top, left + mMore.getMeasuredWidth(),
                top + mMore.getMeasuredHeight());
    }
}
