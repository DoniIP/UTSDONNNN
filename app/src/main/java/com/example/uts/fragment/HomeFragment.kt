package com.example.uts.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"




class HomeFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: SuperheroAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var superheroArrayList : ArrayList<Superhero>

    lateinit var image : Array<Int>
    lateinit var name : Array<String>
    lateinit var description: Array<String>
    lateinit var rate : Array<String>
    lateinit var news : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }

            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_hero)
        recyclerView.layoutManager  = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = SuperheroAdapter(superheroArrayList)
        recyclerView.adapter = adapter

        superheroArrayList = arrayListOf<Superhero>()
        getUserdata()

    }

    private fun getUserdata() {
        for (i in image.indices) {

            val superhero = Superhero(image[i], name[i], description[i], rate[i])
            superheroArrayList.add(superhero)
        }

        var adapter = SuperheroAdapter(superheroArrayList)
        recyclerView.adapter = adapter
        adapter.setOnItemClikListener(object : SuperheroAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                // Toast.makeText(requireActivity(), "You Clicked on Item no. $position", Toast.LENGTH_SHORT).show()

                val intent = Intent(requireActivity(),DetailSuperheroActivity::class.java)
                intent.putExtra("image", superheroArrayList[position].imgSuperhero)
                intent.putExtra("name", superheroArrayList[position].nameSuperhero)
                intent.putExtra("news",news[position])
                startActivity(intent)


            }

        })
    }

    private fun dataInitialize(){
        superheroArrayList = arrayListOf<Superhero>()

        image = arrayOf(
            R.drawable.jayjo,
            R.drawable.asta,
            R.drawable.gojo,
            R.drawable.kento,
            R.drawable.levi,
            R.drawable.makima,
            R.drawable.rengoku,
            R.drawable.saitama,
            R.drawable.sukuna,
            R.drawable.zenitsu,

        )

        name = arrayOf(
            "Jay Jo",
            "Asta",
            "Gojo Satoru",
            "Kento Nanami",
            "Levi Ackerman",
            "Makima",
            "Rengoku Kyojuro",
            "Saitama",
            "Ryoumen Sukuna",
            "Zenitsu Agatsuma",


        )

        description = arrayOf(
            "Wind Breaker",
            "Black Clover",
            "Jujutsu Kaisen",
            "Jujutsu Kaisen",
            "Attack On Titan",
            "Chainsaw Man!",
            "Kimetsu No Yaiba",
            "One Punch Man",
            "Jujutsu Kaisen",
            "Kimetsu No Yaiba",


        )

        rate = arrayOf(
            "10/10",
            "10/10",
            "10/10",
            "9/10",
            "10/10",
            "9/10",
            "10/10",
            "10/10",
            "9.5/10",
            "10/10",

        )

        news = arrayOf(
            "Jay Jo adalah karakter utama dalam serial webtoon berjudul Wind Breaker. Di awal serial, dia cukup introvert yang hanya fokus belajar.\n" +
                    "\n" +
                    "Karena orang tuanya di masa kecil sangat tegas dan mementingkan nilai akademis, mereka menasihatinya bahwa teman bukanlah hal dibutuhkannya, teman hanya akan mengalihkan perhatiannya dari belajar. Sehingga Jay tumbuh menjadi sosok yang pendiam dan dingin. ",
            " Asta adalah pemuda bertubuh pendek dengan otot yang berotot. Dia memiliki mata hijau dan rambut pirang abu berantakan dengan satu untai menonjol ke atas dari tengah kepalanya. Dia menyimpan rambutnya dengan ikat kepala hitam, yang memiliki lambang Banteng Hitam berwarna emas dan memiliki bintang empat berwarna merah dengan tiga jahitan di bagian belakangnya. Dia memiliki banyak bekas luka di sekujur tubuhnya dari latihan fisik yang berat,[11] dan bekas luka besar di perutnya di mana salah satu Harpe milik Mars menusuknya.[12][13]",
            "Gojo Satoru merupakan salah satu karakter utama di anime berjudul Jujutsu Kaisen (2020).\n" +
                    "\n" +
                    "Ia ditampilan sebagai sosok pria yang tinggi dan sangat menarik perhatian terutama ketika bersama dengan murid-muridnya.\n" +
                    "\n" +
                    "Walaupun memiliki rambut yang biasanya diikat ke atas, terkadang ia membiarkan rambutnya tergerai ke bawah ketika mengenakan pakaian yang kasual. ",
            " Kento Nanami Dakimakura adalah karakter cerminan Gojo Satoru tapi memiliki kepribadian yang bertolak belakang. Karakter Dakimakura Kento Nanami ini lahir pada tanggal 3 Juli 1990 yang membuat ia memiliki usia yang sama dengan Gojo Satoru yaitu 28 tahun. \n" +
                    "\n" +
                    "Sayangnya Kento memiliki tinggi badan yang sedikit lebih pendek dari Gojo yaitu 184 cm. Kento memang terlihat lebih tenang dan lembut seperti horoscope-nya yaitu Cancer.",
            " Levi Ackerman adalah salah satu dari 3 orang yang sejauh ini diketahui menyandang marga Ackerman, tapi belum ketahuan apakah dia satu keluarga sama Mikasa atau enggak. FYI, Levi ini lahir saat natal, loh. Meski begitu, sampai saat ini enggak ada yang tau usianya berapa. Yang pasti umur Levi sudah lebih dari 30 tahun! Hmmm.. Ini berdasarkan tweet dari akun resmi @ShingekiKyojin yang isinya adalah pernyataan Hajime Isayama bilang bahwa Levi berusia lebih dari 30 tahun. Kemungkinan, usia Levi ini punya arti penting dalam Attack on Titan. Mungkin juga berhubungan sama klan Ackerman.",
            "Makima merupakan seorang Control Devil (Iblis Control) yang membuatnya bisa mengendalikan makhluk lain, bahkan bisa membuat atau lebih tepatnya memaksa seseorang untuk membuat kontrak tanpa mereka sadari.\n" +
                    "\n" +
                    "Jika kita melihat etimologi dari nama Makima, nama yang ditulis dalam katakana ini sebenarnya tidak memiliki arti apapun.\n" +
                    "\n" +
                    "Namun jika kita hanya mengambil sebagian namanya saja yakni “Maki”, ini bisa diartikan sebagai salah satu perusahaan alat-alat listrik di jepang yang juga membuat gergaji mesin, sederhananya ia mengidolakan manusia gergaji. ",
            "Kyojuro merupakan salah satu pilar di tim pemburu iblis. Dia merupakan Pilar Api, dengan kepribadian yang penuh semangat sesuai dengan gelar yang disandangnya.\n" +
                    "\n" +
                    "Kepribadian Kyojuro terlihat sangat optimis, hal ini juga terlihat dalam anime Kimetsu no Yaiba pada cerita Mugen Train.\n" +
                    "\n" +
                    "Dalam anime Kimetsu no Yaiba: Mugen Train Arc, pasti pecinta anime cukup terkejut dengan kemampuan Kyojuro pada awal episode.\n" +
                    "\n" +
                    "Pasalnya, dia mampu bergerak cepat dengan mengatur pernapasannya ",
            " Ya, Saitama adalah seorang superhero dengan kemampuan yang luar biasa ganas. Bagaimana tidak, Ia bisa mengalahkan semua musuhnya, tak peduli raksasa sebesar apapun, cukup dengan satu pukulan saja!\n" +
                    "\n" +
                    "Nah, karena tak ada yang bisa mengimbangi kekuatannya, Saitama pun mulai bosan dengan hidupnya. Awalnya, Ia ingin melindungi planet tempatnya tinggal, namun secara perlahan Ia mulai fokus untuk mencari lawan yang sepadan saja.",
            "Sukuna adalah tokoh yang egois, berhati dingin, tidak bermoral, dan sangat sadis. Ketika dia bereinkarnasi tak lama setelah Yuji menelan jarinya, dia berkomentar, menyiratkan pembantaian wanita dan anak-anak dan menyamakan mereka dengan belatung yang merayap di sekitar.\n" +
                    "\n" +
                    "Karena kekuatannya yang luar biasa, dia jarang peduli dengan konsekuensi dari tindakannya, bahkan jika ini mempengaruhi inangnya, Yuji Itadori. Bahkan, ia sering mengejek dan menghina Yuji, menyebutnya anak nakal bahkan menertawakan atau menikmati keputusasaan Yuji di berbagai kesempatan. ",
            " Zenitsu Agatsuma adalah seorang pembasmi iblis. Dia pengguna teknik \"Pernapasan Petir\". Zenitsu memiliki kepribadian yang penakut, tetapi memiliki pendirian yang kuat dalam melindungi orang-orang di sekitarnya, khususnya pada perempuan. Ia memiliki pendengaran yang lebih baik dari manusia biasa pada umumnya.",

        )

    }
}