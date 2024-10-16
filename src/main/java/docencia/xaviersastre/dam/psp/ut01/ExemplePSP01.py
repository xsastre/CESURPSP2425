import json
import sys

pelicula = {"El Resplandor":
    {
        "Director":"Kubrick",
        "Any":1980,
        "Actors":[
            {"Nom":"Jack Nicholson"},
            {"Nom":"Shelley Duvall"},
            {"Nom":"Danny Lloyd"},
            {"Nom":"Scatman Crothers"}
        ]
    }
}
print(json.dumps(pelicula))
sys.exit(0)