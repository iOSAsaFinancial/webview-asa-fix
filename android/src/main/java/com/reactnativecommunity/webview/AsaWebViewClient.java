package com.reactnativecommunity.webview;

import android.webkit.WebView;

/**
 * A minimal extension of RNCWebViewClient that blocks URLs using
 * the app's package name as a URL scheme, preventing ERR_UNKNOWN_URL_SCHEME.
 */
public class AsaWebViewClient extends RNCWebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url != null) {
            String appScheme = view.getContext().getPackageName() + "://";
            if (url.startsWith(appScheme)) {
                return true; // Block URLs using app package name as scheme
            }
        }
        return super.shouldOverrideUrlLoading(view, url);
    }
}
