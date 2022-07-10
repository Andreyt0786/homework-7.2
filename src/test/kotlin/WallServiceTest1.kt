import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val commentToWall = CommentToWall(5, true, true, false, false)
        val service = WallService()
        service.add(
            Post(
                1, 9, 2, 1, 35, "Super",
                3, 1, false, commentToWall, arrayOf(audioAttachment(), videoAttachment())
            )
        )
        val result = service.add(
            Post(
                6, 9, 2, 1, 35, "Super",
                3, 1, false, commentToWall, arrayOf(audioAttachment(), videoAttachment())
            )
        )
        val (id) = result
        assertNotEquals(0, id)


    }

    @Test
    fun updateFalse() {
        val commentToWall = CommentToWall(5, true, true, false, false)
        val service = WallService()
        service.add(
            Post(
                6, 9, 2, 1, 35, "Super",
                3, 1, false, commentToWall, arrayOf(audioAttachment(), videoAttachment())
            )
        )
        val post = Post(
            1, 9, 2, 1, 35, "Super",
            3, 1, false, commentToWall, arrayOf(audioAttachment(), videoAttachment())
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
                3, 1, false, commentToWall, arrayOf(audioAttachment(), videoAttachment())
            )
        )
        val post = Post(
            6, 9, 2, 1, 35, "Super",
            3, 1, false, commentToWall, arrayOf(audioAttachment(), videoAttachment())
        )
        val result = service.update(post)
        assertEquals(true, result)

    }

    @Test
    fun createCommentOk() {
        val comment1 = CommentToWall(5, true, true, true, true)
        val comment2 = CommentToWall(1, false, false, false, false)
        val servise = WallService()
        servise.add(
            Post(
                1, 9, 2, 1, 35, "Super",
                3, 1, false, comment1, arrayOf(audioAttachment(), videoAttachment())
            )
        )

        servise.add(
            Post(
                5, 9, 2, 1, 35, "Super",
                3, 1, false, comment1, arrayOf(audioAttachment(), videoAttachment())
            )
        )

        val result = servise.createComment(1, comment2)
        assertEquals(comment2, result)

    }


    @Test(expected = PostNotFoundException::class)
            fun shouldThrow(){
                val comment1 = CommentToWall(5, true, true, true, true)
                val comment2 = CommentToWall(1, false, false, false, false)
                val servise = WallService()
                servise.add(
                    Post(
                        1, 9, 2, 1, 35, "Super",
                        3, 1, false, comment1, arrayOf(audioAttachment(), videoAttachment())
                    )
                )

                servise.add(
                    Post(
                        5, 9, 2, 1, 35, "Super",
                        3, 1, false, comment1, arrayOf(audioAttachment(), videoAttachment())
                    )
                )

                servise.createComment(15,comment2)
            }

}
