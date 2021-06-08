package com.shankara.djtiktoknew;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
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

public class AboutFragment extends DialogFragment {

    private TextView privacyLink,about_content;
    private Button dismiss;
    private WebView webView;
    private String version_name, version_code;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);

        privacyLink = rootView.findViewById(R.id.privacyPolicy);
        dismiss = rootView.findViewById(R.id.dismiss);
        about_content = rootView.findViewById(R.id.about_content);
        webView = rootView.findViewById(R.id.webview_about_privacy);
        TextView app_version = rootView.findViewById(R.id.app_version);

        try {
            PackageInfo pm = requireActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(),0);
            version_name = pm.versionName;
            version_code = String.valueOf(pm.versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        app_version.setText(version_name + version_code);

        privacyPolicyLink();
        btnDismiss();

        return rootView;
    }

    private void privacyPolicyLink() {
        privacyLink.setOnClickListener(v -> {
            privacyLink.setVisibility(View.GONE);
            about_content.setVisibility(View.GONE);
            webView.setWebViewClient(new WebViewClient());
            webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
            webView.loadUrl("file:///android_asset/shankara.html");
            webView.setVisibility(View.VISIBLE);
        });
    }

    private void btnDismiss() {
        dismiss.setOnClickListener(v -> {
            privacyLink.setVisibility(View.VISIBLE);
            about_content.setVisibility(View.VISIBLE);
            webView.setVisibility(View.GONE);
            dismiss();
        });
    }
}
