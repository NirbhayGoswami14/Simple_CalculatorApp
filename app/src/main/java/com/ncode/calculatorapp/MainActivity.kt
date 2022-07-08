package com.ncode.calculatorapp

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import com.ncode.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    var inpu1=0.0
    var inpu2=0.0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val themeFlag=applicationContext.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        if(themeFlag==Configuration.UI_MODE_NIGHT_YES)
        {
            binding.txtOutput.setTextColor(Color.WHITE)
            binding.txtInput2.setTextColor(Color.WHITE)
            binding.txtInput.setTextColor(Color.WHITE)
            binding.txtInput.setHintTextColor(Color.WHITE)
            binding.txtOperation.setTextColor(Color.WHITE)
        }
        binding.btn0.setOnClickListener {
            if(binding.txtOperation.isVisible)
            {
                binding.txtInput2.text=binding.txtInput2.text.toString()+"0"
            }
            else
            {
                binding.txtInput.text=binding.txtInput.text.toString()+"0"
            }
        }
        binding.btn1.setOnClickListener {
            if(binding.txtOperation.isVisible)
            {
                binding.txtInput2.text=binding.txtInput2.text.toString()+"1"
            }
            else
            {
                binding.txtInput.text=binding.txtInput.text.toString()+"1"
            }
        }
        binding.btn2.setOnClickListener {
            if(binding.txtOperation.isVisible)
            {
                binding.txtInput2.text=binding.txtInput2.text.toString()+"2"
            }
            else
            {
                binding.txtInput.text=binding.txtInput.text.toString()+"2"
            }
        }
        binding.btn3.setOnClickListener {
            if(binding.txtOperation.isVisible)
            {
                binding.txtInput2.text=binding.txtInput2.text.toString()+"3"
            }
            else
            {
                binding.txtInput.text=binding.txtInput.text.toString()+"3"
            }
        }
        binding.btn4.setOnClickListener {
            if(binding.txtOperation.isVisible)
            {
                binding.txtInput2.text=binding.txtInput2.text.toString()+"4"
            }
            else
            {
                binding.txtInput.text=binding.txtInput.text.toString()+"4"
            }
        }
        binding.btn5.setOnClickListener {

            if(binding.txtOperation.isVisible)
            {
                binding.txtInput2.text=binding.txtInput2.text.toString()+"5"
            }
            else
            {
                binding.txtInput.text=binding.txtInput.text.toString()+"5"
            }
        }
        binding.btn6.setOnClickListener {
            if(binding.txtOperation.isVisible)
            {
                binding.txtInput2.text=binding.txtInput2.text.toString()+"6"
            }
            else
            {
                binding.txtInput.text=binding.txtInput.text.toString()+"6"
            }
        }
        binding.btn7.setOnClickListener {
            if(binding.txtOperation.isVisible)
            {
                binding.txtInput2.text=binding.txtInput2.text.toString()+"7"
            }
            else
            {
                binding.txtInput.text=binding.txtInput.text.toString()+"7"
            }
        }
        binding.btn8.setOnClickListener {

            if(binding.txtOperation.isVisible)
            {
                binding.txtInput2.text=binding.txtInput2.text.toString()+"8"
            }
            else
            {
                binding.txtInput.text=binding.txtInput.text.toString()+"8"
            }
        }
        binding.btn9.setOnClickListener {
            if(binding.txtOperation.isVisible)
            {
                binding.txtInput2.text=binding.txtInput2.text.toString()+"9"
            }
            else
            {
                binding.txtInput.text=binding.txtInput.text.toString()+"9"
            }
        }
        binding.btnDot.setOnClickListener {
            if(binding.txtOperation.isVisible)
            {
                binding.txtInput2.text=binding.txtInput2.text.toString()+"."
            }
            else
            {
                binding.txtInput.text=binding.txtInput.text.toString()+"."
            }
        }

        binding.btnAc.setOnClickListener {
            binding.txtInput.text=""
            offVisibility()
        }

        binding.btnDel.setOnClickListener {

            if(binding.txtInput2.isVisible && binding.txtInput.text.isNotEmpty() )
            {
                if(binding.txtInput2.text.isNotEmpty())
                {

                    binding.txtInput2.text=binding.txtInput2.text.subSequence(0,binding.txtInput2.text.length-1)
                }
                else
                {
                    if(binding.txtOperation.text.isNotEmpty())
                    {
                        binding.txtOperation.text=binding.txtOperation.text.subSequence(0,binding.txtOperation.text.length-1)
                        offVisibility()
                    }
                }
                return@setOnClickListener
            }
            if(binding.txtInput.text.isNotEmpty())
            {
                binding.txtInput.text=binding.txtInput.text.subSequence(0,binding.txtInput.text.length-1)
            }
        }
        binding.btnDel.setOnLongClickListener {
            binding.txtInput.text=""
            offVisibility()
            true
        }

        binding.btnAddition.setOnClickListener {
            onVisibility()
            binding.txtOperation.text=binding.btnAddition.text
        }
        binding.btnSubtraction.setOnClickListener {
            onVisibility()
            binding.txtOperation.text=binding.btnSubtraction.text
        }
        binding.btnDivision.setOnClickListener {
            onVisibility()
            binding.txtOperation.text=binding.btnDivision.text
        }
        binding.btnMultiplication.setOnClickListener {
            onVisibility()
            binding.txtOperation.text=binding.btnMultiplication.text
        }
        binding.btnModules.setOnClickListener {
            onVisibility()
            binding.txtOperation.text=binding.btnModules.text
        }

        binding.btnEqual.setOnClickListener {
            if(binding.txtOperation.text.toString()!=""&&binding.txtInput2.text.toString()!="")
            {

                operation(binding.txtOperation.text.toString())
            }

        }
    }

    private fun onVisibility()
    {
        if(binding.txtInput.text.toString()!="")
        {
            binding.txtInput2.visibility= View.VISIBLE
            binding.txtOperation.visibility= View.VISIBLE

        }
    }

    private fun offVisibility()
    {
        binding.txtInput2.visibility= View.GONE
        binding.txtOperation.visibility= View.GONE
        binding.txtOutput.visibility=View.GONE

        binding.txtOperation.text=""
        binding.txtInput2.text=""
        binding.txtOutput.text=""
    }

    private fun  operation(string: String)
    {   var res=0.0
        inpu1=binding.txtInput.text.toString().toDouble()
        inpu2=binding.txtInput2.text.toString().toDouble()
        binding.txtOutput.visibility=View.VISIBLE
        when(string)
        {
            "+"->{
                res =inpu1+inpu2
                binding.txtOutput.text=res.toString()
            }
            "-"->{
                res =inpu1-inpu2
                binding.txtOutput.text=res.toString()
            }
            "\u00F7"->{
                res =inpu1/inpu2
                binding.txtOutput.text=res.toFloat().toString()
            }
            "\u00D7"->{
                res =inpu1*inpu2
                binding.txtOutput.text=res.toFloat().toString()
            }
            "%"->{
                res =inpu1%inpu2
                binding.txtOutput.text=res.toFloat().toString()
            }
        }
    }
}