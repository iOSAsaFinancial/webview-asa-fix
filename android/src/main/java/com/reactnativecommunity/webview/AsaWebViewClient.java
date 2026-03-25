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
                // Let the parent dispatch the event to JS (onShouldStartLoadWithRequest)
                // but always block the URL to prevent ERR_UNKNOWN_URL_SCHEME.
                super.shouldOverrideUrlLoading(view, url);
                return true;
            }
        }
        return super.shouldOverrideUrlLoading(view, url);
    }
}
