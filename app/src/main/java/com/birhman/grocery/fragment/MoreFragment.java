package com.birhman.grocery.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.birhman.grocery.R;
import com.birhman.grocery.activity.AboutUsActivity;
import com.birhman.grocery.activity.ContactUsActivity;
import com.birhman.grocery.activity.MainActivity;
import com.birhman.grocery.activity.WebViewActivity;
import com.birhman.grocery.helper.URLConfig;
import com.birhman.grocery.util.AppUtils;

public class MoreFragment extends Fragment implements View.OnClickListener {
    private Context context;

    public static MoreFragment newInstance(){
        MoreFragment moreFragment = new MoreFragment();
        return moreFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        ((MainActivity) getActivity()).setTitle(getResources().getString(R.string.title_more));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getActivity();
        RelativeLayout relativeLayoutAbout = view.findViewById(R.id.rl_about_us);
        RelativeLayout relativeLayoutContact = view.findViewById(R.id.rl_contact_us);
        RelativeLayout relativeLayoutGallery = view.findViewById(R.id.rl_gallery);
        RelativeLayout relativeLayoutVidoes = view.findViewById(R.id.rl_videos);
        RelativeLayout relativeLayoutTestimonial = view.findViewById(R.id.rl_testimonial);
        RelativeLayout relativeLayoutShare = view.findViewById(R.id.rl_share);
        RelativeLayout relativeLayoutRate = view.findViewById(R.id.rl_rate_us);
        RelativeLayout relativeLayoutPrivacy = view.findViewById(R.id.rl_privacy_policy);
        RelativeLayout relativeLayoutTerms = view.findViewById(R.id.rl_terms_conditions);
        RelativeLayout relativeLayoutLogout = view.findViewById(R.id.rl_logout);
        RelativeLayout relativeLayoutPayHistory = view.findViewById(R.id.rl_pay_history);

        relativeLayoutAbout.setOnClickListener(this);
        relativeLayoutContact.setOnClickListener(this);
        relativeLayoutGallery.setOnClickListener(this);
        relativeLayoutVidoes.setOnClickListener(this);
        relativeLayoutTestimonial.setOnClickListener(this);
        relativeLayoutShare.setOnClickListener(this);
        relativeLayoutRate.setOnClickListener(this);
        relativeLayoutPrivacy.setOnClickListener(this);
        relativeLayoutTerms.setOnClickListener(this);
        relativeLayoutLogout.setOnClickListener(this);
        relativeLayoutPayHistory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.rl_about_us:
                intent = new Intent(context, AboutUsActivity.class);
                startActivity(intent);
                break;

            case R.id.rl_contact_us:
                intent = new Intent(context, ContactUsActivity.class);
                startActivity(intent);
                break;

            /*case R.id.rl_gallery:
                intent = new Intent(context, GalleryActivity.class);
                context.startActivity(intent);
                break;

            case R.id.rl_videos:
                intent = new Intent(context, VideosListingActivity.class);
                context.startActivity(intent);
                break;

            case R.id.rl_testimonial:
                intent = new Intent(context, TestimonialListingActivity.class);
                context.startActivity(intent);
                break;*/

            case R.id.rl_share:
                AppUtils.shareApp(context);
                break;

            case R.id.rl_rate_us:
                AppUtils.rateApp(context);
                break;

            case R.id.rl_privacy_policy:
                intent = new Intent(context, WebViewActivity.class);
                intent.putExtra("strUrl", URLConfig.URL_PRIVACY_POLICY);
                intent.putExtra("strHeading", URLConfig.HEADING_PRIVACY);
                startActivity(intent);
                break;

            case R.id.rl_terms_conditions:
                intent = new Intent(context, WebViewActivity.class);
                intent.putExtra("strUrl", URLConfig.URL_TERMS_CONDITIONS);
                intent.putExtra("strHeading", URLConfig.HEADING_TERMS);
                startActivity(intent);
                break;

            /*case R.id.rl_logout:
                SQLiteHandler sqLiteHandler = SQLiteHandler.getInstance(getActivity());
                //    SQLiteHandler sqLiteHandler = new SQLiteHandler(getActivity());
                sqLiteHandler.deleteUser();
                SessionManager sessionManager = new SessionManager(context);
                sessionManager.setLogin(false);

                intent = new Intent(context, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                getActivity().finish();
                break;*/

            /*case R.id.rl_pay_history:
                intent = new Intent(context, PaymentHistoryActivity.class);
                context.startActivity(intent);
                break;*/
        }
    }
}