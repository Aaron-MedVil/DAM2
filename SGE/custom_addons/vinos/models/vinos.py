# -*- coding: utf-8 -*-

from odoo import models, fields, api

## Funcion que retorna los valores de la calidad
def _get_selection(self):
    return ([
       ('bueno', 'Bueno'),
       ('regular', 'Regular'),
       ('malo', 'Malo')])

## Modelo vinos
class vinos(models.Model):
    _name = 'vinos.vinos'
    _description = 'vinos'

    name = fields.Char(string='Nombre')
    calidad = fields.Selection(_get_selection, string='Calidad', default='bueno')
    marca = fields.Many2one('marca.vinos', string='Marca')
    bodega = fields.Many2one('bodega.vinos', string='Bodega')
    embotellado = fields.Date(string='Año embotellado')
    capacidad = fields.Float(string='Capacidad')
    description = fields.Text(string='Descripción')
    image = fields.Image(string="Imagen", max_width=100, max_height=100, width=100, height=100)
    do = fields.Many2one('do.vinos', string='Denominación origen')
    variedad = fields.Many2one('variedad.vinos', string='Variedad')

'''

## Funcion para seleccionar años
@api.model
def year_selection(self):
    year = 1800
    year_list = []
    while year != 2030:
        year_list.append((str(year), str(year)))
        year += 1
    return year_list
'''