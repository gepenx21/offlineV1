package com.shankara.djtiktoknew;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;


public class PrivacyPolicy extends DialogFragment {

    private Button btn_accept, btn_decline;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.privacy_policy, container, false);


        WebView webView = rootView.findViewById(R.id.privacy_policy_dialog);
        btn_accept = rootView.findViewById(R.id.btn_accept);
        btn_decline = rootView.findViewById(R.id.btn_decline);
        TextView privacy_title = rootView.findViewById(R.id.title_privacy);
        TextView gdpr_title = rootView.findViewById(R.id.title_gdpr);
        TextView gdpr_body = rootView.findViewById(R.id.body_gdpr);

        final Typeface medium = Typeface.createFromAsset(requireActivity().getAssets(), "gotham_medium.ttf");
        final Typeface book = Typeface.createFromAsset(getActivity().getAssets(), "gotham_book.ttf");

        privacy_title.setTypeface(medium);
        gdpr_title.setTypeface(medium);
        gdpr_body.setTypeface(book);

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webView.loadUrl("file:///android_asset/shankara.html");

        btnAccept();
        btnDecline();

        return rootView;
    }

    private void btnAccept() {
        btn_accept.setOnClickListener(v -> {
            SharedPreferences settings = requireActivity().getSharedPreferences("hasRunBefore_appIntro", 0);
            SharedPreferences.Editor edit = settings.edit();
            edit.putBoolean("hasRun_appIntro", true);
            edit.apply(); //apply
            dismiss();
        });
    }

    private void btnDecline() {
        btn_decline.setOnClickListener(v -> System.exit(1));
    }
}
