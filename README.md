# react-native-webview-asa

Minimal fix for `react-native-webview` on Android: blocks `ERR_UNKNOWN_URL_SCHEME` by preventing URLs that use the app's package name as a URL scheme from loading.

## Installation

```bash
yarn add react-native-webview-asa
```

> Requires `react-native-webview` >= 13.0.0 as a peer dependency.

## Usage

Replace `WebView` with `AsaWebView` where you need the fix:

```tsx
import { AsaWebView } from 'react-native-webview-asa';

<AsaWebView source={{ uri: 'https://example.com' }} />
```

On iOS, `AsaWebView` is just a re-export of the standard `WebView` — no changes needed.

## How it works

- **3 tiny Java files** that extend the original `react-native-webview` classes
- `AsaWebViewClient` extends `RNCWebViewClient`, adding a URL scheme check before the original `shouldOverrideUrlLoading`
- `AsaWebViewManager` extends `RNCWebViewManager`, swapping in the patched client
- On the JS side, uses `react-native-webview`'s `nativeConfig` prop to use the patched native component
