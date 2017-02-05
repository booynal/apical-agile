
function Http() {
	this.get = function(url, callback) {
		console.log("GET " + url);
		callback(url);
	}
}
var $http = new Http();
var processResults = function(results) {
	console.log("results: " + results)
}
