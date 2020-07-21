
package com.app.travel.model.response

data class TicketResultModel(

    var successList: MutableMap<String,MutableMap<String,String>>,
    
    var failList: MutableList<MutableMap<String,MutableMap<String,String>>>
    
    )