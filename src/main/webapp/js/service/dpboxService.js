$app.factory('dpboxService', ['$resource',function($resource) {
    return $resource('./rest/dptoken/:key/:secret/:code', {
    key : '@key',secret:'@secret',code:'@code'
    }, {
    	getUrl: {method: 'GET', isArray : false},
    	getToken: {method: 'GET', isArray : false},
    	
    	
    });
}]);