module.exports = {
  dependency: {
    platforms: {
      android: {
        packageImportPath: 'import com.asafinancial.webviewasa.AsaWebViewPackage;',
        packageInstance: 'new AsaWebViewPackage()',
      },
      ios: null, // No iOS native code
    },
  },
};
