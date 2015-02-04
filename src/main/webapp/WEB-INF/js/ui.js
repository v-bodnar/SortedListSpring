/**
 * Created by Volodymyr Bodnar on 04.02.2015.
 */
var selectedItemIndex;
$( document ).ready(function() {
    $("#sortedList").has('li').length ? $("#sortedList").show() : $("#sortedList").hide();

});

function add(){
    $("#sortedList").append('<li>'+$("#newItem").val()+'</li>');
    $("#newItem").val('');
    $("#sortedList").has('li').length ? $("#sortedList").show() : $("#sortedList").hide();
    saveToFile();
};

$("#sortedList").on("click","li", function(event) {
    var index = $(this).index();
    var text = $(this).text();
    if (selectedItemIndex != null)
        selectedItemIndex.css('color','black');
    selectedItemIndex = $(this);
    selectedItemIndex.css('color','red');
    $("#newItem").val(text);
    $("#up").show();
    $("#down").show();
    $("#save").show();
    $("#delete").show();
});

$("#up").on("click","", function(event) {
    if (selectedItemIndex.prev().is('li'))
    {
        selectedItemIndex.insertBefore(selectedItemIndex.prev());
    }
    saveToFile();
});

$("#down").on("click","", function(event) {
    if (selectedItemIndex.next().is('li'))
    {
        selectedItemIndex.insertAfter(selectedItemIndex.next())
    }
    saveToFile();
});


$("#save").on("click","", function(event) {
    selectedItemIndex.text($("#newItem").val());
    saveToFile();
});

$("#delete").on("click","", function(event) {

    if (selectedItemIndex.next().is('li')){
        //saving next item
        var tempItem = selectedItemIndex.next();

        //removing current item
        selectedItemIndex.remove();

        //selecting next item
        selectedItemIndex = tempItem;
        selectedItemIndex.css('color','red');
        $("#newItem").val(selectedItemIndex.text());
    }
    else {
        selectedItemIndex.remove();
        $("#newItem").val("");
        if (!$("#sortedList").has('li').length) {
            $("#sortedList").hide();
            $("#up").hide();
            $("#down").hide();
            $("#save").hide();
            $("#delete").hide();
        }
    }
    saveToFile();
});