var app = angular.module('myapp', []);

app.controller('myController', function($scope, $http) {
	$scope.send = function() {
		var f = document.getElementById('myform');
		var form = new FormData(f);

		$http({
			method : 'post',
			url : 'http://localhost:8080/userupload',
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			},
			data : form
		}).then(function(response) {
			alert(response.data);
		});
	}
});