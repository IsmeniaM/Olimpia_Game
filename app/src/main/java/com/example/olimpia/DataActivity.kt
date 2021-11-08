package com.example.olimpia

import android.graphics.drawable.ClipDrawable.VERTICAL
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelStores.of
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.olimpia.data.MainActivityViewModel
import com.example.olimpia.data.RecyclerViewAdapter
import com.example.olimpia.data.db.PlayerEntity
import kotlinx.android.synthetic.main.activity_data.*
import kotlinx.android.synthetic.main.activity_result_names.*
import kotlinx.android.synthetic.main.recyclerview_row.*
import java.util.EnumSet.of

class DataActivity : AppCompatActivity(), RecyclerViewAdapter.RowClicklistener {

    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    lateinit var viewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        recyclerview.apply {
            layoutManager = LinearLayoutManager ( this@DataActivity)
            recyclerViewAdapter = RecyclerViewAdapter(this@DataActivity)
            adapter = recyclerViewAdapter
           // val divider = DividerItemDecoration(applicationContext, VERTICAL)
            //addItemDecoration(divider)
        }

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.getAllPlayersObservers().observe(this, Observer {
            recyclerViewAdapter.setListData(ArrayList(it))
            recyclerViewAdapter.notifyDataSetChanged()
        })

        saveButton.setOnClickListener {
            val name = nameInput.text.toString()
            val email = emailInput.text.toString()




            val correctAnswers = intent.getIntExtra(ConstantsCountry.CORRECT_ANSWERS,0)



            tvScoreData.text = " Your score is $correctAnswers "


            if (saveButton.text.equals("Save")) {
                val player = PlayerEntity(0, name, email)
                viewModel.insertPlayerInfo(player)
            }else {
                val player = PlayerEntity(nameInput.getTag(nameInput.id).toString().toInt(), name,email  // tirar caso n resulte
                )
                viewModel.updatePlayerInfo(player)
                saveButton.setText("Save")
            }
            nameInput.setText("")
            emailInput.setText("")
            myScore.text



        }
    }

    override fun onDeletePlayerClickListener(player: PlayerEntity) {
        viewModel.deletePlayerInfo(player)
    }

    override fun onItemClickListener(player: PlayerEntity) {
        nameInput.setText(player.name)
        emailInput.setText(player.email)
        nameInput.setTag(nameInput.id, player.id)
        saveButton.setText("Update")
    }
}