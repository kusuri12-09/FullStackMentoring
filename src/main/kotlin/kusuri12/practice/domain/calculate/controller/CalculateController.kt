package kusuri12.practice.domain.calculate.controller

import kusuri12.practice.domain.calculate.service.CalculateService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController;

@RestController
class CalculateController(private val calculateService: CalculateService) {

    @GetMapping("/sum")
    fun calcSum(@RequestParam("a") a: String, @RequestParam("b") b: String): String {
        return calculateService.sum(a, b)
    }

    @GetMapping("/sub")
    fun calcSubstract(@RequestParam("a") a: String, @RequestParam("b") b: String): String {
        return calculateService.sub(a, b)
    }

    @GetMapping("/mul")
    fun calcMultiply(@RequestParam("a") a: String, @RequestParam("b") b: String): String {
        return calculateService.mul(a, b)
    }

    @GetMapping("/div")
    fun calcDivision(@RequestParam("a") a: String, @RequestParam("b") b: String): String {
        return calculateService.div(a, b)
    }
}