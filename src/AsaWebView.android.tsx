import React, { forwardRef } from 'react';
import { requireNativeComponent } from 'react-native';
import { WebView } from 'react-native-webview';
import type { WebViewProps } from 'react-native-webview';

const AsaNativeWebView = requireNativeComponent('AsaWebView');

/**
 * Drop-in replacement for WebView that fixes ERR_UNKNOWN_URL_SCHEME
 * by blocking URLs that use the app's package name as a URL scheme.
 *
 * Usage: import { AsaWebView } from 'react-native-webview-asa';
 *        <AsaWebView source={{ uri: '...' }} />
 */
const AsaWebView = forwardRef<WebView, WebViewProps>((props, ref) => (
  <WebView
    ref={ref}
    {...props}
    nativeConfig={{
      component: AsaNativeWebView as any,
      ...props.nativeConfig,
    }}
  />
));

AsaWebView.displayName = 'AsaWebView';

export default AsaWebView;
