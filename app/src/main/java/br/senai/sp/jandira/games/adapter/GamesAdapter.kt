package br.senai.sp.jandira.games.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.HolderGamesLayoutBinding
import br.senai.sp.jandira.games.model.Game

class GamesAdapter(val context: Context) : RecyclerView.Adapter<GamesAdapter.HolderGame>() {

    private var gamesList = listOf<Game>()

    fun updateGamesList(games: List<Game>) {
        this.gamesList = games
        notifyDataSetChanged()
    }

    class HolderGame(view: View): RecyclerView.ViewHolder(view) {
        val textGameTitle = view.findViewById<TextView>(R.id.text_view_game_title)
        val textDeveloper = view.findViewById<TextView>(R.id.text_view_subtitle)
        val textDescription = view.findViewById<TextView>(R.id.text_view_description)
        val gameImage = view.findViewById<ImageView>(R.id.image_game)

        fun bind(game: Game) {
            textGameTitle.text = game.gameName
            textDeveloper.text = game.developer
            textDescription.text = game.description
            gameImage.setImageDrawable(game.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderGame {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_games_layout, parent, false) // O false é no caso de querer ou não mudar o layout

        return HolderGame(view)
    }

    override fun onBindViewHolder(holder: HolderGame, position: Int) {
        holder.bind(gamesList.get(position))
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

}