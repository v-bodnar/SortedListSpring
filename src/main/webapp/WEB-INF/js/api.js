/**
 * Created by Volodymyr Bodnar on 04.02.2015.
 */

function saveToFile(){
    listItems=[];

    $("#sortedList li").each(function() {
        //listItems.push(JSON.stringify({id:$(this).index(), value:$(this).text()}));
        listItems.push($(this).text());
    });
    if (listItems.length == 0)
        var data = {"listItems":null}
    else
        var data = {"listItems":listItems};

    $.post("ajaxtest", data,function(e) {
    }, "json");

}
