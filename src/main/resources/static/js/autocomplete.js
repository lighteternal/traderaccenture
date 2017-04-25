$(document).ready(function(){


var options = {

    url: "/js/heroes.json",

    categories: [{
       
        listLocation: "stocks",
        maxNumberOfElements: 4,
        header: "Trader Stocks"
    }],

    getValue: function(element) {
        return element.character;
    },

    template: {
        type: "description",
        fields: {
            description: "realName"
        }
    },

    list: {
        maxNumberOfElements: 8,
        match: {
            enabled: true
        },
        sort: {
            enabled: true
        }
    },

    theme: "square"
};

$("#example-heroes").easyAutocomplete(options);



});