package kusuri12.practice.domain.test.controller

import kusuri12.practice.domain.test.service.TestService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(private val testService: TestService) {

    @GetMapping("/All")
    fun getAll() = testService.getAll()

    @GetMapping("/memo")
    fun memo(@RequestParam("id") id: Int): String {
        return testService.getMemo(id)
    }

    @GetMapping("/delete")
    fun delete(@RequestParam("id") id: Int): String {
        testService.deleteMEmo(id)
        return "complete"
    }

    @GetMapping("/edit")
    fun edit(@RequestParam("memo") memo: String, @RequestParam("id") id: Int): String {
        testService.editMemo(memo, id)
        return "complete"
    }

    @GetMapping("/create")
    fun create(@RequestParam("memo") memo: String): String {
        testService.create(memo)
        return "complete"
    }
}