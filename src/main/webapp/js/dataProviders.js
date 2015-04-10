/**
 * Created by Michal_Bucki on 05/03/2015.
 */
var app = angular.module("dataProviders", []);


app.factory('todoFactory', ['$http', function($http) {

    var urlBase = 'http://localhost:8081/rest';
    var dataFactory = {};

    dataFactory.getTodos = function () {
        return $http.get(urlBase+"/todos");
    };

    dataFactory.getTodo = function (id) {
        return $http.get(urlBase + '/' + id);
    };

    dataFactory.setTodoStatus = function(id, status){

        $http({
            url: urlBase+"/todos",
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            data: {id: id, done: status}
        }).then(function(response) {
                console.log(urlBase+"/todos post SUCCESS")
            },
            function(response) { // optional
                console.log(urlBase+"/todos post FAILED")
            }
        );
    };

    dataFactory.addTodo = function(name){
        $http({
            url: urlBase+"/todos",
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            data: {name: name}
        }).then(function(response) {
                console.log(urlBase+"/todos post SUCCESS")
            },
            function(response) { // optional
                console.log(urlBase+"/todos post FAILED")
            }
        );
    };

    return dataFactory;
}]);