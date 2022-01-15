package pl.grabski.mybatisproject.api;

import org.springframework.web.bind.annotation.*;
import pl.grabski.mybatisproject.mapper.CityMapper;
import pl.grabski.mybatisproject.model.Cities;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CitiesApi {
    private final CityMapper cityMapper;

    public CitiesApi(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    @GetMapping
    public List<Cities> getAll() {
        return cityMapper.findALl();
    }

    @GetMapping("/id/{id}")
    public Cities getOne(@PathVariable Long id) {
        return cityMapper.findById(id);
    }

    @PostMapping
    public void addCity(@RequestBody Cities city) {
        cityMapper.insert(city);
    }

    @GetMapping("/del/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityMapper.deleteId(id);
    }
}
