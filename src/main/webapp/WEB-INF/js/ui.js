/**
 * Created by Volodymyr Bodnar on 04.02.2015.
 */
var selectedItemIndex;
var serverUrl = "SaveList";

$( document ).ready(function() {
    //Checking if List has at least one item and showing it or hiding
    $("#sortedList").has('li').length ? $("#sortedList").show() : $("#sortedList").hide();
    //No items are selected, so buttons are not needed. Hide them
    $("#button-group").hide();
});

//Add button listener
$("#add").on("click","", function(event) {
    //Adding new Item to the list
    $("#sortedList").append('<li class="list-group-item">'+$("#newItem").val()+'</li>');
    //Clearing input field
    $("#newItem").val('');
    //Checking if List has at least one item and showing it or hiding
    $("#sortedList").has('li').length ? $("#sortedList").show() : $("#sortedList").hide();
    //Saving list to file
    saveToFile(serverUrl);
});

//Up button listener
$("#up").on("click","", function(event) {
    //If previous item exists move item before it
    if (selectedItemIndex.prev().is('li'))
    {
        selectedItemIndex.insertBefore(selectedItemIndex.prev());
    }
    //Saving list to file
    saveToFile(serverUrl);
});

//Down button listener
$("#down").on("click","", function(event) {
    //If next item exists move item after it
    if (selectedItemIndex.next().is('li'))
    {
        selectedItemIndex.insertAfter(selectedItemIndex.next())
    }
    //Saving list to file
    saveToFile(serverUrl);
});

$("#save").on("click","", function(event) {
    //Saving new item value
    selectedItemIndex.text($("#newItem").val());
    //Saving list to file
    saveToFile(serverUrl);
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
        //removing item
        selectedItemIndex.remove();
        //cleaning input field
        $("#newItem").val("");
        if (!$("#sortedList").has('li').length) {
            $("#sortedList").hide();
            $("#button-group").hide();
        }
    }
    //Saving list to file
    saveToFile(serverUrl);
});

$("#sortedList").on("click","li", function(event) {
    var index = $(this).index();
    var text = $(this).text();
    if (selectedItemIndex != null)
        selectedItemIndex.css('color','black');
    selectedItemIndex = $(this);
    selectedItemIndex.css('color','red');
    $("#newItem").val(text);
    $("#button-group").show();
});