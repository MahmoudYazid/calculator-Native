package com.yazid.calculator.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.yazid.calculator.R
import com.yazid.calculator.ViewModel.ViewModelClass
import com.yazid.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding : ActivityMainBinding
    private val model: ViewModelClass by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        // enable show scroll
        binding.ShowNumber.setMovementMethod(ScrollingMovementMethod())
        //Functions of numbers
        binding.Btm1.setOnClickListener{

            model.AddNumberBesideAction(binding.Btm1.text.toString())


        }
        binding.Btm2.setOnClickListener{

            model.AddNumberBesideAction(binding.Btm2.text.toString())


        }
        binding.Btm3.setOnClickListener{

            model.AddNumberBesideAction(binding.Btm3.text.toString())


        }
        binding.Btm4.setOnClickListener{

            model.AddNumberBesideAction(binding.Btm4.text.toString())


        }
        binding.Btm5.setOnClickListener{

            model.AddNumberBesideAction(binding.Btm5.text.toString())


        }

        binding.Btm6.setOnClickListener{

            model.AddNumberBesideAction(binding.Btm6.text.toString())


        }
        binding.Btm7.setOnClickListener{

            model.AddNumberBesideAction(binding.Btm7.text.toString())


        }

        binding.Btm8.setOnClickListener{

            model.AddNumberBesideAction(binding.Btm8.text.toString())


        }

        binding.Btm9.setOnClickListener{

            model.AddNumberBesideAction(binding.Btm9.text.toString())


        }

        binding.ZeroBtm.setOnClickListener{

            model.AddNumberBesideAction(binding.ZeroBtm.text.toString())


        }
        binding.DotBtm.setOnClickListener{

            model.AddNumberBesideAction(binding.DotBtm.text.toString())


        }
        binding.clearBtm.setOnClickListener{

            model.ClearFunction()


        }

        // processes btms Impl
        binding.MultiblyBtm.setOnClickListener{
            // take Livedata value and put it in First Value
            model.FirstNum.value=model.LiveDate.value
            // reset live data
            model.LiveDate.value=""
            // put process as multiply by
            model.process.value="*"



        }

        binding.DevidedBtm.setOnClickListener{
            // take Livedata value and put it in First Value
            model.FirstNum.value=model.LiveDate.value
            // reset live data
            model.LiveDate.value=""
            // put process as multiply by
            model.process.value="/"



        }

        binding.PlusBtm.setOnClickListener{
            // take Livedata value and put it in First Value
            model.FirstNum.value=model.LiveDate.value
            // reset live data
            model.LiveDate.value=""
            // put process as multiply by
            model.process.value="+"



        }

        binding.minusBtm.setOnClickListener{
            // take Livedata value and put it in First Value
            model.FirstNum.value=model.LiveDate.value
            // reset live data
            model.LiveDate.value=""
            // put process as multiply by
            model.process.value="-"



        }


        // Equal Implement

        binding.EqualBtm.setOnClickListener{
            // put second Value in Second LiveData
            model.SecondNum.value= model.LiveDate.value
            // reset Live Data
            model.LiveDate.value=""
            // Check the operation
            when(model.process.value){
                "*"->{
                    model.MultiplyAction()
                }
                "-"->{
                    model.MinusAction()
                }
                "+"->{
                    model.PlusAction()
                }
                "/"->{
                    model.DevidedByAction()
                }


            }

        }
        //Get Live Data
        model.LiveDate.observe(this, Observer {
            binding.ShowNumber.text =  it.toString()
        })


        val view = binding.root


        setContentView(view)
    }
}