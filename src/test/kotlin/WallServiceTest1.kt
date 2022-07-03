import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val commentToWall = CommentToWall(5, true, true, false, false)
        val service = WallService()
        service.add(Post(
                1, 9, 2, 1, 35, "Super",
            3, 1, false, commentToWall
        ))
        val result = service.add(
            Post(
                6, 9, 2, 1, 35, "Super",
                3, 1, false, commentToWall
            )
        )
        val(id)=result
        assertNotEquals(0,id)


    }

    @Test
    fun updateFalse() {
        val commentToWall = CommentToWall(5, true, true, false, false)
        val service = WallService()
        service.add(
            Post(
                6, 9, 2, 1, 35, "Super",
                3, 1, false, commentToWall
            )
        )
        val post = Post(
            1, 9, 2, 1, 35, "Super",
            3, 1, false, commentToWall
        )
        val result = service.update(post)
        assertEquals(false, result)
    }


    @Test
    fun updateTrue() {
        val commentToWall = CommentToWall(5, true, true, false, false)
        val service = WallService()
        service.add(
            Post(
                6, 9, 2, 1, 35, "Super",
                3, 1, false, commentToWall
            )
        )
        val post = Post(
            6, 9, 2, 1, 35, "Super",
            3, 1, false, commentToWall
        )
        val result = service.update(post)
        assertEquals(true, result)

    }


}

