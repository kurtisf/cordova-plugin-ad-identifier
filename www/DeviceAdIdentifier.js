
var exec = require('cordova/exec');

module.exports = {
  getUserInfo: function(success, fail) {
    exec(success, fail, 'DeviceAdIdentifierPlugin', 'getUserInfo', []);
  }
};

