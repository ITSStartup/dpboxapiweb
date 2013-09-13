var dpboxController = function($scope, $location,dpboxService) {
	$scope.key;
	$scope.secret;
	$scope.code;
	$scope.dpbox;
	$scope.dpboxService = new dpboxService();
	$scope.dropurl;
	
	$scope.getUrl = function(appkey,appsecret){
	dpboxService.getUrl({key:appkey,secret:appsecret},function(data){
			$scope.dropurl = data;
				
		});
	};
	
	$scope.getToken = function(appcode){
		dpboxService.getToken({code:appcode}, function(data){
			$scope.dpbox = data;
			
		});
	};
	

};
dpboxController.$inject = [ '$scope','$location', 'dpboxService' ];