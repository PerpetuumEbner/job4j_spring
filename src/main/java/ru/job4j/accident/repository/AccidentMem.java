package ru.job4j.accident.repository;

import ru.job4j.accident.model.Accident;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccidentMem {
    private final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();

    private final AtomicInteger ID = new AtomicInteger(4);

    private AccidentMem() {
        AccidentTypeMem accidentType = new AccidentTypeMem();

        RuleMem ruleMem = new RuleMem();

        accidents.put(1, new Accident(
                1, "Отсутствие документов и регистрации автомобиля",
                "Управление транспортным средством, не зарегистрированным в установленном порядке",
                "Санкт-Петербург",
                accidentType.findById(2),
                Stream.of(ruleMem.findById(1)).collect(Collectors.toSet())));
        accidents.put(2, new Accident(
                2, "Техническое состояние транспортного средства",
                "Управление транспортным средством с заведомо неисправными тормозной системой (за исключением стояночного тормоза), рулевым управлением или сцепным устройством (в составе поезда)",
                "Екатеринбург",
                accidentType.findById(1),
                Stream.of(ruleMem.findById(2), ruleMem.findById(3)).collect(Collectors.toSet())));
        accidents.put(3, new Accident(
                3, "Состояние опьянения и отсутствие права управления",
                "Управление транспортным средством водителем, лишенным права управления транспортными средствами",
                "Челябинск",
                accidentType.findById(1),
                Stream.of(ruleMem.findById(1)).collect(Collectors.toSet())));
        accidents.put(4, new Accident(
                4, "Скоростной режим",
                "Превышение установленной скорости движения транспортного средства на величину более 20, но не более 40 километров в час",
                "Казань",
                accidentType.findById(3),
                Stream.of(ruleMem.findById(1), ruleMem.findById(2), ruleMem.findById(4)).collect(Collectors.toSet())));
    }

    public void create(Accident accident) {
        accident.setId(ID.incrementAndGet());
        accidents.put(accident.getId(), accident);
    }

    public Accident findById(int id) {
        return accidents.get(id);
    }

    public Collection<Accident> findAll() {
        return accidents.values();
    }

    public void update(Accident accident) {
        accidents.replace(accident.getId(), accident);
    }
}