var app = angular.module('app-root', []);

app.controller('mycontroller', function($scope, $http) {
	$scope.title = "Hello World";
	$scope.customers = [];

	$scope.start = function() {
		$http.get("http://localhost:8080/api/getall").then(
				function(response) {
					console.log(response);
					$scope.customers = response.data;
					console.log($scope.customers);
				});
	}
	$scope.addCus = function() {

		$http({
			method : "post",
			url : "http://localhost:8080/api/add",
			data : {
				fullname : $scope.fullname,
				username : $scope.username,
				password : $scope.password
			}
		}).then(function(response) {
			alert(response.data.message);
			$scope.start();
		});
	}
	$scope.del = function(id) {
		var url = "http://localhost:8080/api/delete/" + id;
		$http.get(url).then(function(response) {
			alert(response.data.message);
			$scope.start();
		});
	}
});