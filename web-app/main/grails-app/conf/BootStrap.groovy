import com.partytime.Component
import com.partytime.Drink
import com.partytime.Ingredient
import com.partytime.MusicStyle
import com.partytime.Place
import com.partytime.Promo
import com.partytime.QuickParty
import com.partytime.Review
import com.partytime.User

class BootStrap {

	def init = { servletContext ->
		Ingredient botellaGancia = new Ingredient(name: "Botella de Gancia", price: 40.0).save()
		Ingredient botellaSprite = new Ingredient(name: "Botella de Sprite", price: 10.0).save()
		Ingredient botellaCoca = new Ingredient(name: "Botella de Coca Cola", price: 10.0).save()
		Ingredient botellaFernet = new Ingredient(name: "Botella de Fernet", price: 60.0).save()
		Ingredient botellaCerveza = new Ingredient(name: "Botella de Cerveza", price: 25.0).save()
		Ingredient botellaVodka = new Ingredient(name: "Botella de Vodka", price: 80.0).save()
		Ingredient lataEnergizante = new Ingredient(name: "Lata de energizante", price: 5.0).save()
		Ingredient botellaJugo = new Ingredient(name: "Botella de Jugo", price: 8.0).save()
		Ingredient botellaChampagne = new Ingredient(name: "Botella de Champagne", price: 120.0).save()

		Component fernetAl20 = new Component(ingredient: botellaFernet, amount: "20% del vaso").save()
		Component ganciaAl50 = new Component(ingredient: botellaGancia, amount: "50% del vaso").save()
		Component cocaAl80 = new Component(ingredient: botellaCoca, amount: "80% del vaso").save()
		Component spriteAl50 = new Component(ingredient: botellaSprite, amount: "50% del vaso").save()
		Component cervezaAl100 = new Component(ingredient: botellaCerveza, amount: "todo el vaso").save()
		Component vodkaAl50 = new Component(ingredient: botellaVodka, amount: "50% del vaso").save()
		Component energizanteAl30 = new Component(ingredient: lataEnergizante, amount: "30% del vaso").save()
		Component energizanteAl50 = new Component(ingredient: lataEnergizante, amount: "50% del vaso").save()
		Component jugoAl20 = new Component(ingredient: botellaJugo, amount: "20% del vaso").save()
		Component champagneAl70 = new Component(ingredient: botellaChampagne, amount: "70% del vaso").save()

		Drink ganciaConSprite = new Drink(name: "Gancia con Sprite", components: [ganciaAl50, spriteAl50], preparation:"batir todo y agregar Azucar").save()
		Drink fernetConCoca = new Drink(name: "Fernet con Coca", components: [fernetAl20, cocaAl80], preparation:"servir primero el Fernet").save()
		Drink cerveza = new Drink(name: "Cerveza", components: [cervezaAl100], preparation:"servir despacio").save()
		Drink fuegoSagrado = new Drink(name: "Fuego Sagrado", components: [vodkaAl50, energizanteAl50], preparation:"").save()
		Drink tropicalEnergy = new Drink(name: "Tropical Energy", components: [vodkaAl50, energizanteAl30, jugoAl20], preparation:"").save()
		Drink acidPsycho = new Drink(name: "Acid Psycho", components: [champagneAl70, energizanteAl30], preparation:"").save()
		
		MusicStyle musicStyleRock = new MusicStyle(name: "Rock").save()
		MusicStyle musicStyleElectro = new MusicStyle(name: "Electro").save()
		MusicStyle musicStyleReggaeton = new MusicStyle(name: "Reggaeton").save()
		MusicStyle musicStyleCumbia = new MusicStyle(name: "Cumbia").save()
		MusicStyle musicStyleUnder = new MusicStyle(name: "Under").save()
		MusicStyle musicStyle80 = new MusicStyle(name: "80's").save()

		User user1 = new User(name: "User1", bornDate: new Date()).save()
		User user2 = new User(name: "User2", bornDate: new Date()).save()
		User user3 = new User(name: "User3", bornDate: new Date()).save()

		Review review1 = new Review(title:"review1", body:"body1", score:4, author: user1).save()
		Review review2 = new Review(title:"review2", body:"body2", score:4, author: user1).save()
		Review review3 = new Review(title:"review3", body:"body3", score:5, author: user2).save()

		Promo promo1 = new Promo(title: "2x1 en tragos seleccionados", description: "toda la noche", drink: fernetConCoca).save()
		Promo promo2 = new Promo(title: "Chicas gratis hasta 2:00 AM", description: "").save()

		Place place1 = new Place(name: "Sabado fiestero", minimumAge: 18, street: "Av Santa Fe", number:"1234", city:"CABA", reviews: [review1, review3]).save()
		Place place2 = new Place(name: "El rincon del mal", minimumAge: 18, street: "Av Santa Fe", number:"1111", city:"CABA", reviews: [review2], promos: [promo1, promo2]).save()
		Place place3 = new Place(name: "Mucha-chica", minimumAge: 21, street: "Av Cordoba", number:"1234", city:"CABA", reviews: [], promos: [promo2]).save()

		QuickParty quickparty1= new QuickParty(meetingPint: "La casa de Lito", host: user1, place: place1, description: "Mi cumple",startDateTime: new Date()).save()

		//ScheduledParty scheduledParty1 = new ScheduledParty().save()
	}
	def destroy = {
	}
}
