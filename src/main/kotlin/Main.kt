fun main() {
val pageVisitsTracking = PageVisitsTracking("home",56)
    pageVisitsTracking.trackPageVisits("home")
    pageVisitsTracking.trackPageVisits("sports")
    pageVisitsTracking.trackPageVisits("entertainment")
    pageVisitsTracking.trackPageVisits("signup")

    val frequentlyVisitedPages= pageVisitsTracking.acquirePages()
    println(frequentlyVisitedPages)

}
class PageVisitsTracking(val pages:String,val value:Int) {
    // page visits should contain page  and the value of the number of visits.The string is forthe page the value for the number of visits
    private val pageVisits = mutableMapOf<String, Int>()

    fun trackPageVisits(pages: String) {
        pageVisits[pages] = pageVisits.getOrDefault(pages, 0) + 1
    }

    fun acquirePages(): List<Pair<String, Int>>{
        var pageVisits = pageVisits.toList().sortedByDescending { it.second }.take(5)
        return pageVisits
    }

}



