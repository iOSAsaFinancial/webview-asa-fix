package com.asafinancial.webviewasa;

import androidx.annotation.NonNull;

import com.facebook.react.uimanager.ThemedReactContext;
import com.reactnativecommunity.webview.AsaWebViewClient;
import com.reactnativecommunity.webview.RNCWebViewManager;
import com.reactnativecommunity.webview.RNCWebViewWrapper;

/**
 * Extends the original RNCWebViewManager, only overriding the WebViewClient
 * to use AsaWebViewClient with the URL scheme fix.
 * All props, commands, and events are inherited from the original.
 */
public class AsaWebViewManager extends RNCWebViewManager {

    public static final String REACT_CLASS = "AsaWebView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected void addEventEmitters(@NonNull ThemedReactContext reactContext, RNCWebViewWrapper viewWrapper) {
        viewWrapper.getWebView().setWebViewClient(new AsaWebViewClient());
    }
}
