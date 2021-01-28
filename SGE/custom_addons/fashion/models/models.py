# -*- coding: utf-8 -*-

from odoo import models, fields, api

## Modelo que crea los campos que utilizaremos para añadir informacion
class fashion(models.Model):
    _name = 'fashion.fashion'
    _description = 'fashion.fashion'
    
    # Campos
    # name = fields.Char(string="Name")

class seasson(models.Model):
    _name = 'seassons.template'
    _description = 'seassons.template'

    name = fields.Char(string="Name", required=True)
    startDate = fields.Date('Start date', required=True, default=fields.Date.today())
    endDate = fields.Date('End date')