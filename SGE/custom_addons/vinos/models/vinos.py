# -*- coding: utf-8 -*-

from odoo import models, fields, api
from datetime import datetime

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

    name = fields.Char(string='Nombre', required=True, help='Indica el nombre del vino')
    calidad = fields.Selection(_get_selection, string='Calidad', default='bueno', required=True, help='Indica la calidad del vino')
    embotellado = fields.Date(string='Año embotellado', default=datetime.today(), required=True, help='Indica la fecha de embotellado')
    capacidad = fields.Float(string='Capacidad', default=0.75, required=True, help='Indica la capacidad en litros de la botella')
    image = fields.Image(string="Imagen", max_width=1000, max_height=1000, width=300, height=300, help='Foto de la botella')
    description = fields.Text(string='Descripción', help='Descripción del vino')

    # Models reference fields
    marca = fields.Many2one('marca.vinos', string='Marca', required=True, help='Indica la marca con la que se vende el vino')
    bodega = fields.Many2one('bodega.vinos', string='Bodega', required=True, help='Indica la bodega que produce el vino')
    do = fields.Many2one('do.vinos', string='Denominación origen', required=True, help='Indica la denominación de origen de vino')
    variedad = fields.Many2many('variedad.vinos', string='Variedad', required=True, help='Indica las variedades de la uva que contiene el vino')