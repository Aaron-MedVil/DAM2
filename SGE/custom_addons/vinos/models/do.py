# -*- coding: utf-8 -*-

from odoo import models, fields, api

## Modelo denominacion de origen
class do(models.Model):
	_name = 'do.vinos'
	_description = 'denominacion_origen'

	name = fields.Char(string='Nombre', required=True)