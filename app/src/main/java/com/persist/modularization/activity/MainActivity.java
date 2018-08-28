package com.persist.modularization.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.persist.modularization.R;
import com.persist.modularization.fragment.HomeFragment;
import com.persist.modularization.fragment.MessageFragment;
import com.persist.modularization.fragment.MineFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.content_layout)
    RelativeLayout contentLayout;
    @BindView(R.id.home_image_view)
    TextView homeImageView;
    @BindView(R.id.home_layout_view)
    RelativeLayout homeLayoutView;
    @BindView(R.id.fish_image_view)
    TextView fishImageView;
    @BindView(R.id.pond_layout_view)
    RelativeLayout pondLayoutView;
    @BindView(R.id.message_image_view)
    TextView messageImageView;
    @BindView(R.id.message_layout_view)
    RelativeLayout messageLayoutView;
    @BindView(R.id.mine_image_view)
    TextView mineImageView;
    @BindView(R.id.mine_layout_view)
    RelativeLayout mineLayoutView;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;

    private HomeFragment mHomeFragment;
    private MineFragment mMineFragment;
    private MessageFragment mMessageFragment;
    private Fragment mCurrentFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        homeImageView.setBackgroundResource(R.drawable.comui_tab_home_selected);

        mHomeFragment = new HomeFragment();
        getFragmentManager().beginTransaction().replace(R.id.content_layout, mHomeFragment).commit();

    }

    @OnClick({R.id.home_layout_view, R.id.pond_layout_view, R.id.message_layout_view, R.id.mine_layout_view})
    public void onViewClicked(View view) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.home_layout_view:
                homeImageView.setBackgroundResource(R.drawable.comui_tab_home_selected);
                messageImageView.setBackgroundResource(R.drawable.comui_tab_message);
                mineImageView.setBackgroundResource(R.drawable.comui_tab_person);
                hideFragment(mMessageFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content_layout, mHomeFragment);
                } else {
                    mCurrentFragment = mHomeFragment;
                    fragmentTransaction.show(mHomeFragment);
                }
                break;
            case R.id.pond_layout_view:
                break;
            case R.id.message_layout_view:
                homeImageView.setBackgroundResource(R.drawable.comui_tab_home);
                messageImageView.setBackgroundResource(R.drawable.comui_tab_message_selected);
                mineImageView.setBackgroundResource(R.drawable.comui_tab_person);
                hideFragment(mHomeFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                if (mMessageFragment == null) {
                    mMessageFragment = new MessageFragment();
                    fragmentTransaction.add(R.id.content_layout, mMessageFragment);
                } else {
                    mCurrentFragment = mMessageFragment;
                    fragmentTransaction.show(mMessageFragment);
                }
                break;
            case R.id.mine_layout_view:
                homeImageView.setBackgroundResource(R.drawable.comui_tab_home);
                messageImageView.setBackgroundResource(R.drawable.comui_tab_message);
                mineImageView.setBackgroundResource(R.drawable.comui_tab_person_selected);
                hideFragment(mHomeFragment, fragmentTransaction);
                hideFragment(mMessageFragment, fragmentTransaction);
                if (mMineFragment == null) {
                    mMineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.content_layout, mMineFragment);
                } else {
                    mCurrentFragment = mMineFragment;
                    fragmentTransaction.show(mMineFragment);
                }
                break;
        }

        fragmentTransaction.commit();
    }

    /**
     * 隐藏Fragment
     *
     * @param fragment            将要隐藏的Fragment
     * @param fragmentTransaction fragment事务
     */
    private void hideFragment(Fragment fragment, FragmentTransaction fragmentTransaction) {
        if (fragment != null) {
            fragmentTransaction.hide(fragment);
        }
    }
}
