#test calculadora.py

#importacion del modulo unittest
import unittest
from calculadora import sumar, restar

class TestCalculadora(unittest.TestCase):

    def test_sumar(self):
        #prueba de suma de numeros positivos
        self.assertEqual(sumar(4,3), 7)
        #prueba de suma de numero positivo con  negativo
        self.assertEqual(sumar(-2,2), 0)
        #prueba de suma de numeros negativos
        self.assertEqual(sumar(-2, -3), -5)
        #prueba de suma con ceros
        self.assertEqual(sumar(0, 0), 0)
        self.assertEqual(sumar(5, 0), 5)

    def test_restar(self):
        #prueba de resta de numeros positivos
        self.assertEqual(restar(8, 3), 5)
        #prueba de resta de numero positivo con negativo
        self.assertEqual(restar(-1, 3), -4)
        #prueba de resta de numeros negativos
        self.assertEqual(restar(-2, -6), 4)
        #prueba de resta con ceros
        self.assertEqual(restar(0, 0), 0)
        self.assertEqual(restar(7, 0), 7)

#Esto asegura que los tests solo se ejecuten cuando este archivo se ejecuta directamente
if __name__  ==  '__main__':
    unittest.main()