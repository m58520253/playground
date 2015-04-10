/**
 * Created by Michal_Bucki on 03/03/2015.
 */
var app = angular.module("todoModule", ['dataProviders', 'todoUtils']);

app.constant('name', 'Juan rodrigez abarka')
app.constant('name', 'Michal');

app.controller("todoCtrl",['$scope', 'todoFactory', 'name',
    function($scope, todoFactory, name) {
        todoFactory.getTodos().
            success(function(data) {
                $scope.todoRows = data;
            });
        $scope.name = name;
    }]
);


app.directive('todo', function () {

    return {
        restrict: 'E',
        replace: true,
        scope: {
            data:'='
        },
        templateUrl: 'view/directives/todo.html',
        controller: function($scope, todoFactory) {

            $scope.$watch('data', function(newValue, oldValue) {
                $scope.rows =newValue;
            });

            $scope.setTodoStatus = function(id, status){
                todoFactory.setTodoStatus(id, status);
            }
        }
    };
}).directive('todoInputField', [ 'todoFactory', function (todoFactory) {
    return {
        restrict: 'E',
        replace: true,
        scope: { title: '=zippyTitle' },
        template: '<input type="text" ng-model="foo"/>',

        link: function (scope, element) {
            element.bind('keydown keypress', function (event) {
                if (event.which === 13) {
                    todoFactory.addTodo(scope.foo);
                    event.preventDefault();
                }

            });


        }
    };
}]);

