package kusuri12.practice.domain.test.service

import kusuri12.practice.domain.test.repository.TestRepository
import org.springframework.stereotype.Service

@Service
class TestService(private val testRepository: TestRepository) {

    fun getAll() = testRepository.getAll()

    fun getMemo(id: Int): String {
        return testRepository.get(id)
    }

    fun deleteMEmo(id: Int) {
        testRepository.remove(id)
    }

    fun editMemo(memo: String, id: Int) {
        testRepository.set(id, memo)
    }

    fun create(memo: String) {
        testRepository.add(memo)
    }
}