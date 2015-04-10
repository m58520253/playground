/**
 * Created by Michal_Bucki on 13/03/2015.
 */
var utilModule = angular.module("todoUtils", []);


utilModule.directive('header', function () {
    return {
        restrict: 'A', //This menas that it will be used as an attribute and NOT as an element. I don't like creating custom HTML elements
        replace: true,
        css: 'css/directives/header.css',
        scope: {user: '='}, // This is one of the cool things :). Will be explained in post.
        templateUrl: "view/directives/header.html",
        controller: ['$scope', '$filter', function ($scope, $filter) {
            // Your behaviour goes here :)
        }]
    }
});


utilModule.directive('footer', function () {
    return {
        restrict: 'A', //This menas that it will be used as an attribute and NOT as an element. I don't like creating custom HTML elements
        replace: true,
        css: 'css/directives/footer.css',
        templateUrl: "view/directives/footer.html",
        controller: ['$scope', '$filter', function ($scope, $filter) {
            // Your behaviour goes here :)
        }]
    }
});