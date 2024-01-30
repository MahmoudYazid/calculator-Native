package com.yazid.calculator.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.math.BigDecimal
import java.math.BigInteger

class ViewModelClass : ViewModel() {
    public val  LiveDate = MutableLiveData<String?>("")
    public val  process = MutableLiveData<String?>("")
    public val  SecondNum = MutableLiveData<String?>("")
    public val  FirstNum = MutableLiveData<String?>("")
    public fun ClearFunction(){
        LiveDate.value = ""
        process.value=""
        SecondNum.value =""
        FirstNum.value = ""
    }
    public fun PlusAction(){
        LiveDate.value = (FirstNum.value?.toBigDecimal()?.plus(SecondNum.value?.toBigDecimal()!!)).toString()
    }

    public fun MinusAction(){
        LiveDate.value = (FirstNum.value?.toBigDecimal()?.minus(SecondNum.value?.toBigDecimal()!!)).toString()


    }

    public fun MultiplyAction(){
        LiveDate.value = (FirstNum.value?.toBigDecimal()?.times(SecondNum.value?.toBigDecimal()!!)).toString()

    }

    public fun DevidedByAction(){
        LiveDate.value = (FirstNum.value?.toBigDecimal()?.div(SecondNum.value?.toBigDecimal()!!)).toString()


    }


    public  fun AddNumberBesideAction(x:String):Unit{

        if (LiveDate.value.toString().contains('.') && x=="." ){
            return Unit
        }

        if (LiveDate.value.toString()=="" && x=="." ){
            LiveDate.value ="0."
            return Unit


        }

        var Final_Value = LiveDate.value?.toString() + x.toString()



        LiveDate.value = Final_Value.toString()


    }
}


