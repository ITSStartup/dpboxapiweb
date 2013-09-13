

	$app = angular.module('app',['ngResource']);
	
	$app.config(function($routeProvider,$httpProvider,$locationProvider){
				//routes
		$routeProvider.
		when('/',{templateUrl:'view/home.html',controller:dpboxController}).
		when('/generatetoken',{templateUrl:'view/token.html',controller:dpboxController}).
		otherwise(
				{
					redirectTo:'/'
				});
		

	$httpProvider.responseInterceptors.push(function($q,$rootScope){
		return function(promise){
			return promise.then(function(response){
				return (response);
			},function(response){
				$data = response.data;
				$error = $data.error;
				if($error && $error.text){
					console.log("ERROR: " + $error.text);
				}
				else{
					if(response.status=404)
					console.log("page not found");
				}
				return $q.reject(response);
			});
		};
	});
});
	


			
	
