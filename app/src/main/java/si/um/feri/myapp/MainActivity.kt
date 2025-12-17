package si.um.feri.myapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.aachartmodel.aainfographics.aachartcreator.*
import si.um.feri.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        drawChartByMonths()
        /*drawChartByYears()
        drawLineChart()
        drawPieChart()*/
        //drawAreaChart()
        drawSplineChart()
        drawScatterChart()
        drawRadarChart()
    }

    private fun baseAnimation(model: AAChartModel): AAChartModel {
        return model
            .dataLabelsEnabled(true)
            .animationType(AAChartAnimationType.Elastic)
            .animationDuration(2000)
    }

    private fun drawChartByMonths() {
        val model = baseAnimation(
            AAChartModel()
                .chartType(AAChartType.Column)
                .title("Buddy Stats")
                .subtitle("Kenya by months")
                .categories(arrayOf(
                    "Jan","Feb","Mar","Apr","May","Jun",
                    "Jul","Aug","Sep","Oct","Nov","Dec"
                ))
                .series(
                    arrayOf(
                        AASeriesElement()
                            .name("Frequency")
                            .data(arrayOf(30,40,60,34,45,29,39,30,40,60,29,32))
                    )
                )
        )
        binding.aaChartViewMonth.aa_drawChartWithChartModel(model)
    }

    /*private fun drawChartByYears() {
        val model = baseAnimation(
            AAChartModel()
                .chartType(AAChartType.Bar)
                .title("Buddy Stats")
                .subtitle("Kenya by years")
                .categories(arrayOf(
                    "2019","2020","2021","2022","2023","2024"
                ))
                .series(
                    arrayOf(
                        AASeriesElement()
                            .name("Frequency")
                            .data(arrayOf(390,300,400,600,290,320))
                    )
                )
        )
        binding.aaChartViewYear.aa_drawChartWithChartModel(model)
    }

    private fun drawLineChart() {
        val model = baseAnimation(
            AAChartModel()
                .chartType(AAChartType.Line)
                .title("Growth trend")
                .subtitle("Last 6 months")
                .categories(arrayOf("Jan","Feb","Mar","Apr","May","Jun"))
                .series(
                    arrayOf(
                        AASeriesElement()
                            .name("Users")
                            .data(arrayOf(120,180,260,320,410,520))
                    )
                )
        )
        binding.aaChartViewLine.aa_drawChartWithChartModel(model)
    }

    private fun drawPieChart() {
        val model = baseAnimation(
            AAChartModel()
                .chartType(AAChartType.Pie)
                .title("User distribution")
                .series(
                    arrayOf(
                        AASeriesElement()
                            .name("Share")
                            .data(arrayOf(
                                arrayOf("Android", 65),
                                arrayOf("iOS", 25),
                                arrayOf("Other", 10)
                            ))
                    )
                )
        )
        binding.aaChartViewPie.aa_drawChartWithChartModel(model)
    }*/

    private fun drawAreaChart() {
        val model = AAChartModel()
            .chartType(AAChartType.Area)
            .title("Monthly Revenue")
            .subtitle("Area Chart Example")
            .categories(arrayOf("Jan","Feb","Mar","Apr","May","Jun"))
            .series(
                arrayOf(
                    AASeriesElement()
                        .name("Revenue")
                        .data(arrayOf(1200, 1500, 1800, 2100, 2600, 3000))
                )
            )
            .dataLabelsEnabled(true)
            .animationType(AAChartAnimationType.EaseOutCubic)

        binding.aaChartViewArea.aa_drawChartWithChartModel(model)
    }

    private fun drawSplineChart() {
        val model = AAChartModel()
            .chartType(AAChartType.Spline)
            .title("Temperature Change")
            .subtitle("Spline Chart Example")
            .categories(arrayOf("Mon","Tue","Wed","Thu","Fri","Sat","Sun"))
            .series(
                arrayOf(
                    AASeriesElement()
                        .name("Temperature °C")
                        .data(arrayOf(14, 16, 18, 17, 19, 21, 20))
                )
            )
            .dataLabelsEnabled(true)

        binding.aaChartViewSpline.aa_drawChartWithChartModel(model)
    }

    private fun drawScatterChart() {
        val model = AAChartModel()
            .chartType(AAChartType.Scatter)
            .title("Height vs Weight")
            .subtitle("Scatter Chart Example")
            .series(
                arrayOf(
                    AASeriesElement()
                        .name("Users")
                        .data(arrayOf(
                            arrayOf(160, 55),
                            arrayOf(165, 60),
                            arrayOf(170, 68),
                            arrayOf(175, 75),
                            arrayOf(180, 82)
                        ))
                )
            )
            .animationType(AAChartAnimationType.Elastic)

        binding.aaChartViewScatter.aa_drawChartWithChartModel(model)
    }

    private fun drawRadarChart() {
        val model = AAChartModel()
            .chartType(AAChartType.Line)
            .polar(true)
            .title("Skill Comparison")
            .categories(arrayOf(
                "Speed", "Strength", "Endurance",
                "Agility", "Technique"
            ))
            .series(
                arrayOf(
                    AASeriesElement()
                        .name("Player A")
                        .data(arrayOf(80, 70, 90, 85, 75)),
                    AASeriesElement()
                        .name("Player B")
                        .data(arrayOf(65, 85, 80, 70, 90))
                )
            )
            .dataLabelsEnabled(true)

        binding.aaChartViewRadar.aa_drawChartWithChartModel(model)
    }


}
