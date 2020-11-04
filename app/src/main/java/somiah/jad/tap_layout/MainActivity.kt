package somiah.jad.tap_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var tabLyout: TabLayout
    lateinit var tabViewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLyout = findViewById(R.id.tabs)
        tabViewPager = findViewById(R.id.pager)

        tabViewPager.adapter = object : FragmentStateAdapter(this){
            override fun getItemCount(): Int {
                return 3
            }

            override fun createFragment(position: Int): Fragment {
                return when(position){
                    0 -> Fragment_one.newInstance("","")
                    1 -> Fragment_two.newInstance("","")
                    2 -> Fragment_three.newInstance("","")
                    else -> Fragment_three.newInstance("","")
                }
            }

        }
        TabLayoutMediator(tabLyout,tabViewPager){ tab, position ->
            when(position){
                0 -> { tab.text = "TAB_1"
                       tab.setIcon(R.drawable.ic_list)}
                1 -> { tab.text = "TAB_2"
                       tab.setIcon(R.drawable.ic_list)}
                2 -> { tab.text = "TAB_3"
                       tab.setIcon(R.drawable.ic_list)}
                else -> null
            }
        }.attach()

        tabLyout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, " This${tab?.text.toString()}", Toast.LENGTH_SHORT) .show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
        })
    }
}