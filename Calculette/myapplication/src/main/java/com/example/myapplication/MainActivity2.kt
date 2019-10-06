package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import fragment.ArticlesFragment

class MainActivity2 : AppCompatActivity() {

    lateinit var spinner: Spinner
    lateinit var planetes:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //useFragment()
        bindView()
    }

    private fun useFragment(){

        //créer une instance du fragment
        val fragment = ArticlesFragment ()
        //créer un transaction sur le fragment manager
        supportFragmentManager.beginTransaction().apply {
            //replacer le précédent fragment, s'il existe
            replace(R.id.fragment_container, fragment)
            //ajouter la transaction dans la stack
            addToBackStack(null)
        }.commit()
        //finalement, on valide la transaction

    }


    private fun bindView(){

        //recupérer une liste de string depuis les ressources
        planetes = resources.getStringArray(R.array.planetes)
        //recupérer l'instance du spinner dans la vue
        spinner = findViewById(R.id.spinner)
        //instancier l'adapteur
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,planetes)
        //associer l'adapter au spinner
        spinner.adapter = adapter
        //Listener quand l'utilisateur selectionne un élément
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(baseContext, "Vous n'avez rien selectionné", Toast.LENGTH_LONG).show()
            }
            override fun onItemSelected(adapter: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(baseContext, "Vous avez selectionné ${planetes[position]}", Toast.LENGTH_LONG).show()
            }
        }

    }

    // needs to be implemented
    //fun onViewCreated


}
