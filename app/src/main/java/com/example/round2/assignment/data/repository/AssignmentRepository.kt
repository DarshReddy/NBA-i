package com.example.round2.assignment.data.repository

import com.example.round2.assignment.data.api.APIService
import javax.inject.Inject

class AssignmentRepository @Inject constructor(
    private val apiService: APIService
) {

    suspend fun getPlayersData(pageNumber: Int) = apiService.getPlayersData(pageNumber)

    fun getStaticData(): List<String> {

        return listOf(
            "He's in a boy band which doesn't make much sense for a snake.",
            "There were white out conditions in the town; subsequently, the roads were impassable.",
            "The doll spun around in circles in hopes of coming alive.Patricia loves the sound of nails strongly pressed against the chalkboard.",
            "She was only made the society president because she can whistle with her toes.",
            "He told us a very exciting adventure story.",
            "There were three sphered rocks congregating in a cubed room.",
            "I've traveled all around Africa and still haven't found the gnu who stole my scarf.",
            "The river stole the gods.",
            "There was coal in his stocking and he was thrilled.",
            "Jason lived his life by the motto, Anything worth doing is worth doing poorly.",
            "He ran out of money, so he had to stop playing poker.",
            "They desperately needed another drummer since the current one only knew how to play bongos.",
            "Today I bought a raincoat and wore it on a sunny day.",
            "Fluffy pink unicorns are a popular status symbol among macho men.",
            "He didn't heed the warning and it had turned out surprisingly well.",
            "He is good at eating pickles and telling women about his emotional problems.",
            "I ate a sock because people on the Internet told me to.",
            "It was her first experience training a rainbow unicorn.",
            "Barking dogs and screaming toddlers have the unique ability to turn friendly neighbors into cranky enemies.",
            "It was the best sandcastle he had ever seen.",
            "There's a growing trend among teenagers of using frisbees as go-cart wheels.",
            "He wondered why at 18 he was old enough to go to war, but not old enough to buy cigarettes.",
            "The light that burns twice as bright burns half as long.",
            "Strawberries must be the one food that doesn't go well with this brand of paint.",
            "I used to live in my neighbor's fishpond, but the aesthetic wasn't to my taste.",
            "The toy brought back fond memories of being lost in the rain forest.",
            "That must be the tenth time I've been arrested for selling deep-fried cigars.",
            "The estate agent quickly marked out his territory on the dance floor.",
            "It's never been my responsibility to glaze the donuts."
        )
    }
}